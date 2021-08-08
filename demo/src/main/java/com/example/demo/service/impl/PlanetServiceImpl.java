package com.example.demo.service.impl;

import com.example.demo.dto.PlanetDto;
import com.example.demo.dto.PlanetSaveDto;
import com.example.demo.dto.PlanetUpdateDto;
import com.example.demo.entity.Planet;
import com.example.demo.entity.Status;
import com.example.demo.mapper.PlanetMapper;
import com.example.demo.repository.PlanetRepository;
import com.example.demo.service.PlanetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PlanetServiceImpl implements PlanetService {

    private final PlanetRepository planetRepository;
    private final EntityManager entityManager;
    private final PlanetMapper planetMapper;

    @Autowired
    public PlanetServiceImpl(PlanetRepository planetRepository, EntityManager entityManager, PlanetMapper planetMapper) {
        this.planetRepository = planetRepository;
        this.entityManager = entityManager;
        this.planetMapper = planetMapper;
    }

    @Override
    public List<PlanetDto> getPlanets() {
        return planetRepository.findAll()
                .stream()
                .map(planetMapper::toDTO)
                .sorted(Comparator.comparing(PlanetDto::getId))
                .collect(Collectors.toList());

    }

    @Override
    @Transactional
    public PlanetDto update(PlanetUpdateDto dto) {
        Planet planet = new Planet();
        if (planetRepository.findById(dto.getId()).isPresent()) {
            planet = planetRepository.findById(dto.getId()).get();
        }
        if (dto.getStatus() != null)
            planet.setStatus(dto.getStatus());
        else if (dto.getTeamId() != null)
            planet.setTeamId(dto.getTeamId());
        Planet updatedPlanet = planetRepository.saveAndFlush(planet);
        entityManager.refresh(updatedPlanet);
        return planetMapper.toDTO(updatedPlanet);
    }

    @Override
    @Transactional
    public PlanetDto save(PlanetSaveDto dto) {
        Planet planet = new Planet();
        planet.setName(dto.getName());
        planet.setTeamId(dto.getTeamId());
        planet.setDescription(dto.getDescription());
        planet.setImage(dto.getImage());
        planet.setStatus(Status.TODO);
        Planet updatedPlanet = planetRepository.saveAndFlush(planet);
        entityManager.refresh(updatedPlanet);
        return planetMapper.toDTO(updatedPlanet);
    }
}
