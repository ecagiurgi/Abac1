package com.example.demo.dto;

import com.example.demo.entity.Team;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RobotDto {
    private Integer id;
    private String name;
    private Team team;
}
