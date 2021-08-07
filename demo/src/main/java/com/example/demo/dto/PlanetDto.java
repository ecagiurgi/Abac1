package com.example.demo.dto;

import com.example.demo.entity.Status;
import com.example.demo.entity.Team;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PlanetDto {
    private Integer id;
    private String description;
    private String name;
    private String image;
    private Status status;
    private Team team;
}
