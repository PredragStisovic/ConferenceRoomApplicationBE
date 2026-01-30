/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.converter.impl;

import com.example.demo.converter.Converter;
import com.example.demo.domain.KorisnikEntity;
import com.example.demo.dto.KorisnikDto;
import org.springframework.stereotype.Component;

/**
 *
 * @author predrag
 */
@Component
public class KorisnikDtoEntityConverter implements Converter<KorisnikDto, KorisnikEntity>{

    @Override
    public KorisnikDto toDto(KorisnikEntity e) {
        return new KorisnikDto(e.getKorisnikId(), e.getEmail(), e.getSifra(), e.getIme(), e.getPrezime(), e.getUloga());
    }

    @Override
    public KorisnikEntity toEntity(KorisnikDto t) {
        if(t.getUloga() != null){
           return new KorisnikEntity(t.getEmail(), t.getIme(), t.getPrezime(), t.getUloga());
        }
        return new KorisnikEntity(t.getEmail(), t.getIme(), t.getPrezime());
    }
    
}
