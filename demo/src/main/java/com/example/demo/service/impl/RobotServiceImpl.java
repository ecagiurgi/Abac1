package com.example.demo.service.impl;

import com.example.demo.dto.RobotDto;
import com.example.demo.dto.RobotDto;
import com.example.demo.mapper.RobotMapper;
import com.example.demo.mapper.RobotMapper;
import com.example.demo.repository.RobotRepository;
import com.example.demo.service.RobotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RobotServiceImpl implements RobotService {

    private final RobotRepository robotRepository;
    private final RobotMapper robotMapper;

    @Autowired
    public RobotServiceImpl(RobotRepository robotRepository, RobotMapper robotMapper) {
        this.robotRepository = robotRepository;
        this.robotMapper = robotMapper;
    }

    @Override
    public List<RobotDto> getRobotsByTeamId(Integer teamId) {
        return robotRepository.findByTeamId(teamId).stream()
                .map(robotMapper::toDTO)
                .collect(Collectors.toList());
    }
}
