package com.example.demo.service.impl;

import com.example.demo.dto.PlanetDto;
import com.example.demo.dto.PlanetSaveAndUpdateDto;
import com.example.demo.entity.Planet;
import com.example.demo.mapper.PlanetMapper;
import com.example.demo.repository.PlanetRepository;
import com.example.demo.repository.TeamRepository;
import com.example.demo.service.PlanetService;
import javassist.bytecode.ByteArray;
import org.hibernate.engine.jdbc.BlobProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.sql.rowset.serial.SerialBlob;
import javax.sql.rowset.serial.SerialException;
import javax.transaction.Transactional;
import java.io.*;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.SQLException;
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
    public PlanetDto update(PlanetSaveAndUpdateDto dto) {
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

}
