/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.service.impl;

import com.example.demo.converter.impl.SalaDtoEntityConverter;
import com.example.demo.dao.SalaRepository;
import com.example.demo.domain.SalaEntity;
import com.example.demo.dto.FilterSalaDto;
import com.example.demo.dto.SalaDto;
import com.example.demo.service.SalaService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

/**
 *
 * @author predrag
 */
@Service
public class SalaServiceImpl implements SalaService{
    
    private final SalaRepository salaRepository;
    private final SalaDtoEntityConverter converter;
    
    @Autowired
    public SalaServiceImpl(SalaRepository salaRepository, SalaDtoEntityConverter converter) {
        this.salaRepository = salaRepository;
        this.converter = converter;
    }

    @Override
    public SalaDto pronadjiSaluPoIdu(int salaId) {
        Optional<SalaEntity> pronadjenaSala = salaRepository.findById(salaId);
        if(!pronadjenaSala.isPresent()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Ne postoji sala sa ovim ID-em");
        }
        SalaEntity sala = pronadjenaSala.get();
        return converter.toDto(sala);
    }

    @Override
    public List<SalaDto> filtrirajSale(FilterSalaDto dto) {
        int page = dto.getPage();
        int size = dto.getSize();

        Pageable pageable = PageRequest.of(page, size);

        Page<SalaEntity> resultPage = salaRepository.findFiltered(
            dto.getMinimalCapacity(),
            dto.getName(),
            pageable
        );

        return resultPage.stream()
            .map(converter::toDto)
            .toList();
    }

    @Override
    public SalaDto kreirajSalu(SalaDto salaDto) {
        SalaEntity salaEntitetZaKreiranje = converter.toEntity(salaDto);
        SalaEntity kreiranaSala = salaRepository.save(salaEntitetZaKreiranje);
        return converter.toDto(kreiranaSala);
    }

    @Override
    public void obrisiSalu(int salaId) {
        Optional<SalaEntity> sala = salaRepository.findById(salaId);
        if(!sala.isPresent()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Ne postoji sala sa ovim ID-em");
        } else {
            SalaEntity salaZaBrisanje = sala.get();
            salaRepository.delete(salaZaBrisanje);
        }
    }
    
}
