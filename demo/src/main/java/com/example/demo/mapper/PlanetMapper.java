package com.example.demo.mapper;

import com.example.demo.dto.PlanetDto;
import com.example.demo.dto.PlanetSaveAndUpdateDto;
import com.example.demo.entity.Planet;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel="spring")
public abstract class PlanetMapper {
    public abstract Planet toEntity(PlanetDto dto);

    public abstract void toEntityUpdate(@MappingTarget Planet entity, PlanetSaveAndUpdateDto dto);

    public abstract PlanetDto toDTO(Planet entity);
}
