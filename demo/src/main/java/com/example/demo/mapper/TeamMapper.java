package com.example.demo.mapper;

import com.example.demo.dto.PlanetDto;
import com.example.demo.dto.PlanetSaveAndUpdateDto;
import com.example.demo.dto.TeamDto;
import com.example.demo.entity.Planet;
import com.example.demo.entity.Team;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel="spring")
public abstract class TeamMapper {
    public abstract TeamDto toDTO(Team entity);
}
