package com.example.demo.service;

import com.example.demo.dto.PlanetDto;
import com.example.demo.dto.PlanetSaveAndUpdateDto;

import java.util.List;

public interface PlanetService {
    List<PlanetDto> getPlanets();

    PlanetDto update(PlanetSaveAndUpdateDto dto);

}
