package com.example.demo.mapper;

import com.example.demo.dto.TeamDto;
import com.example.demo.entity.Team;
import org.mapstruct.Mapper;

@Mapper(componentModel="spring")
public abstract class TeamMapper {
    public abstract TeamDto toDTO(Team entity);
}
