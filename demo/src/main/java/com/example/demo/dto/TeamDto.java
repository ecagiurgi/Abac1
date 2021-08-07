package com.example.demo.dto;

import com.example.demo.entity.Capitan;
import com.example.demo.entity.Capitan;
import com.example.demo.entity.Shuttle;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TeamDto {
    private Integer id;
    private String name;
    private Capitan capitan;
    private Shuttle shuttle;
}
