/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.converter.impl;

import com.example.demo.converter.Converter;
import com.example.demo.domain.TerminEntity;
import com.example.demo.dto.TerminDto;
import java.time.LocalDateTime;
import org.springframework.stereotype.Component;

/**
 *
 * @author predrag
 */
@Component
public class TerminDtoEntityConverter implements Converter<TerminDto, TerminEntity> {

    @Override
    public TerminDto toDto(TerminEntity e) {
        return new TerminDto(e.getTerminId(), e.getDatumVremePocetka(), e.getDatumVremeKraja(), e.getNaziv(), e.getOpis(), e.getSala(), e.getZahtevaoKorisnik(), e.getOdobrioKorisnik(), e.getTipTermina());
    }

    @Override
    public TerminEntity toEntity(TerminDto t) {
        return new TerminEntity(t.getDatumVremePocetka(), t.getDatumVremeKraja(), t.getNaziv(), t.getOpis(), t.getSala(), t.getZahtevaoKorisnik(), t.getOdobrioKorisnik(), t.getTipTermina());
    }
    
}
