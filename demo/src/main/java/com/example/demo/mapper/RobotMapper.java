package com.example.demo.mapper;

import com.example.demo.dto.RobotDto;
import com.example.demo.dto.RobotDto;
import com.example.demo.entity.Robot;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel="spring")
public abstract class RobotMapper {
    public abstract Robot toEntity(RobotDto dto);

    public abstract void toEntityUpdate(@MappingTarget Robot entity, RobotDto dto);

    public abstract RobotDto toDTO(Robot entity);
}
