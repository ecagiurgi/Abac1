package com.example.demo.dto;

import com.example.demo.entity.Status;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PlanetSaveAndUpdateDto {
    private Integer id;
    private Status status;
    private Integer teamId;
}
