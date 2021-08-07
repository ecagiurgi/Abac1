package com.example.demo.mapper;

import com.example.demo.dto.CapitanDto;
import com.example.demo.entity.Capitan;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel="spring")
public abstract class CapitanMapper {
    public abstract Capitan toEntity(CapitanDto dto);

    public abstract void toEntityUpdate(@MappingTarget Capitan entity, CapitanDto dto);

    public abstract CapitanDto toDTO(Capitan entity);
}
