package com.example.demo.service;

import com.example.demo.dto.CapitanDto;
import com.example.demo.dto.CapitanLoginDto;
import com.example.demo.dto.CapitanRegisterDto;

public interface CapitanService {
    CapitanDto register(CapitanRegisterDto registerDto);

    CapitanDto login(CapitanLoginDto loginDTO);
}
