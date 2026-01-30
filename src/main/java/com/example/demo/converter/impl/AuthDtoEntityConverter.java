/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.converter.impl;

import com.example.demo.converter.Converter;
import com.example.demo.domain.KorisnikEntity;
import com.example.demo.dto.RegistracijaDto;
import org.springframework.stereotype.Component;

/**
 *
 * @author predrag
 */
@Component
public class AuthDtoEntityConverter implements Converter<RegistracijaDto, KorisnikEntity>{

    @Override
    public RegistracijaDto toDto(KorisnikEntity e) {
        return new RegistracijaDto();
    }

    @Override
    public KorisnikEntity toEntity(RegistracijaDto t) {
        if(t.getUloga() != null){
           return new KorisnikEntity(t.getEmail(), t.getIme(), t.getPrezime(), t.getUloga());
        }
        return new KorisnikEntity(t.getEmail(), t.getIme(), t.getPrezime());
    }
    
}
