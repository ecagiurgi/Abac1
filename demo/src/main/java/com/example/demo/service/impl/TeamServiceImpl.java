package com.example.demo.service.impl;

import com.example.demo.dto.TeamDto;
import com.example.demo.mapper.TeamMapper;
import com.example.demo.repository.TeamRepository;
import com.example.demo.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TeamServiceImpl implements TeamService {

    private final TeamRepository teamRepository;
    private final TeamMapper teamMapper;

    @Autowired
    public TeamServiceImpl(TeamRepository teamRepository, TeamMapper teamMapper) {
        this.teamRepository = teamRepository;
        this.teamMapper = teamMapper;
    }

    @Override
    public List<TeamDto> getTeams() {
        return teamRepository.findAll()
                .stream()
                .map(teamMapper::toDTO)
                .collect(Collectors.toList());
    }
}
