package com.example.demo.controller;

import com.example.demo.dto.TeamDto;
import com.example.demo.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/team")
@CrossOrigin(origins = "http://localhost:4200")
public class TeamRestController {

    private final TeamService teamService;

    @Autowired
    public TeamRestController(TeamService teamService) {
        this.teamService = teamService;
    }

    @GetMapping("/list")
    public List<TeamDto> list() {
        return teamService.getTeams();
    }

}
