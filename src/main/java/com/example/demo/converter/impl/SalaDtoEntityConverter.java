/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.converter.impl;

import com.example.demo.converter.Converter;
import com.example.demo.domain.SalaEntity;
import com.example.demo.dto.SalaDto;
import org.springframework.stereotype.Component;

/**
 *
 * @author predrag
 */
@Component
public class SalaDtoEntityConverter implements Converter<SalaDto, SalaEntity>{

    @Override
    public SalaDto toDto(SalaEntity e) {
        return new SalaDto(e.getNaziv(), e.getKapacitet());
    }

    @Override
    public SalaEntity toEntity(SalaDto t) {
        return new SalaEntity(t.getNaziv(), t.getKapacitet());
    }
    
}
