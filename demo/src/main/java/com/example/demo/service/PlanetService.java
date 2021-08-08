package com.example.demo.service;

import com.example.demo.dto.PlanetDto;
import com.example.demo.dto.PlanetSaveDto;
import com.example.demo.dto.PlanetUpdateDto;

import java.util.List;

public interface PlanetService {
    List<PlanetDto> getPlanets();

    PlanetDto update(PlanetUpdateDto dto);

    PlanetDto save(PlanetSaveDto dto);
}
