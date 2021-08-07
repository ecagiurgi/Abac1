package com.example.demo.controller;


import com.example.demo.dto.CapitanDto;
import com.example.demo.dto.CapitanLoginDto;
import com.example.demo.dto.CapitanRegisterDto;
import com.example.demo.service.CapitanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/capitan")
@CrossOrigin(origins = "http://localhost:4200")
public class CapitanRestController {

    private final CapitanService capitanService;

    @Autowired
    public CapitanRestController(CapitanService capitanService) {
        this.capitanService = capitanService;
    }

    @PostMapping("/register")
    public CapitanDto register(@RequestBody CapitanRegisterDto registerDto){
        return capitanService.register(registerDto);
    }

    @PostMapping("/login")
    public CapitanDto login(@RequestBody CapitanLoginDto loginDTO) {
        return capitanService.login(loginDTO);
    }
}
