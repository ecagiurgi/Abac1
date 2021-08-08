package com.example.demo.controller;


import com.example.demo.dto.PlanetDto;
import com.example.demo.dto.PlanetSaveDto;
import com.example.demo.dto.PlanetUpdateDto;
import com.example.demo.service.PlanetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/planet")
@CrossOrigin(origins = "http://localhost:4200")
public class PlanetRestController {

    private final PlanetService planetService;

    @Autowired
    public PlanetRestController(PlanetService planetService) {
        this.planetService = planetService;
    }

    @GetMapping("/list")
    public List<PlanetDto> list() {
        return planetService.getPlanets();
    }

    @PutMapping("/update")
    public PlanetDto update(@RequestBody PlanetUpdateDto planet) {
        return planetService.update(planet);
    }

    @PostMapping("/save")
    public PlanetDto save(@RequestBody PlanetSaveDto planet) {
        return planetService.save(planet);
    }
}
