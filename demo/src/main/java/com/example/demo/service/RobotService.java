package com.example.demo.service;

import com.example.demo.dto.RobotDto;

import java.util.List;

public interface RobotService {
    List<RobotDto> getRobotsByTeamId(Integer teamId);
}
