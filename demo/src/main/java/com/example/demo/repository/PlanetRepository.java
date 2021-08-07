package com.example.demo.repository;

import com.example.demo.entity.Planet;
import com.example.demo.entity.Team;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlanetRepository extends JpaRepository<Planet, Integer> {
    Planet findByTeam(Team team);
}
