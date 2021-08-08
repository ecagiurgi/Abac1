package com.example.demo.mapper;

import com.example.demo.dto.PlanetDto;
import com.example.demo.dto.PlanetUpdateDto;
import com.example.demo.entity.Planet;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel="spring")
public abstract class PlanetMapper {
    public abstract Planet toEntity(PlanetDto dto);

    public abstract void toEntityUpdate(@MappingTarget Planet entity, PlanetUpdateDto dto);

    public abstract PlanetDto toDTO(Planet entity);
}
