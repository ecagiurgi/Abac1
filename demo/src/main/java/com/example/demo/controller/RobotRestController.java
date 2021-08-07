package com.example.demo.controller;


import com.example.demo.dto.RobotDto;
import com.example.demo.service.RobotService;
import com.example.demo.service.RobotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/robot")
@CrossOrigin(origins = "http://localhost:4200")
public class RobotRestController {

    private final RobotService robotService;

    @Autowired
    public RobotRestController(RobotService robotService) {
        this.robotService = robotService;
    }

    @GetMapping("/listByTeamId")
    public List<RobotDto> register(@RequestParam("teamId") Integer teamId){
        return robotService.getRobotsByTeamId(teamId);
    }
}
