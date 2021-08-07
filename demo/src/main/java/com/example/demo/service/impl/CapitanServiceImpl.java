package com.example.demo.service.impl;

import com.example.demo.dto.CapitanDto;
import com.example.demo.dto.CapitanLoginDto;
import com.example.demo.dto.CapitanRegisterDto;
import com.example.demo.entity.Capitan;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.mapper.CapitanMapper;
import com.example.demo.repository.CapitanRepository;
import com.example.demo.service.CapitanService;
import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CapitanServiceImpl implements CapitanService {

    private final CapitanRepository capitanRepository;
    private final CapitanMapper capitanMapper;

    @Autowired
    public CapitanServiceImpl(CapitanRepository capitanRepository, CapitanMapper capitanMapper) {
        this.capitanRepository = capitanRepository;
        this.capitanMapper = capitanMapper;
    }

    @Override
    public CapitanDto register(CapitanRegisterDto capitanDto) {
        Capitan capitan = new Capitan();
        capitan.setUsername(capitanDto.getUsername());
        capitan.setName(capitanDto.getName());
        capitan.setPassword((new String(Base64.encodeBase64(capitanDto.getPassword().getBytes()))));
        return capitanMapper.toDTO(capitanRepository.save(capitan));
    }

    @Override
    public CapitanDto login(CapitanLoginDto loginDTO) {
        Capitan capitan = capitanRepository.findByUsername(loginDTO.getUsername());
        if (capitan == null) {
            throw new ResourceNotFoundException("Capitan", "username", loginDTO.getUsername());
        } else {
            if (new String(Base64.encodeBase64(loginDTO.getPassword().getBytes())).equals(capitan.getPassword())) {
                return capitanMapper.toDTO(capitan);
            } else {
                throw new ResourceNotFoundException("Username or password incorrect!");
            }
        }
    }
}
