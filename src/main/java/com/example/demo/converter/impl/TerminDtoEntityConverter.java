/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.converter.impl;

import com.example.demo.converter.Converter;
import com.example.demo.dao.KorisnikRepository;
import com.example.demo.dao.SalaRepository;
import com.example.demo.dao.TipTerminaRepository;
import com.example.demo.domain.KorisnikEntity;
import com.example.demo.domain.TerminEntity;
import com.example.demo.dto.KorisnikDto;
import com.example.demo.dto.SalaDto;
import com.example.demo.dto.TerminDto;
import com.example.demo.dto.TipTerminaDto;
import java.time.LocalDateTime;
import org.springframework.stereotype.Component;

/**
 *
 * @author predrag
 */
@Component
public class TerminDtoEntityConverter implements Converter<TerminDto, TerminEntity> {
    
    
    private final SalaRepository salaRepository;
    private final KorisnikRepository korisnikRepository;
    private final TipTerminaRepository tipTerminaRepository;

    public TerminDtoEntityConverter(
            SalaRepository salaRepository,
            KorisnikRepository korisnikRepository,
            TipTerminaRepository tipTerminaRepository) {

        this.salaRepository = salaRepository;
        this.korisnikRepository = korisnikRepository;
        this.tipTerminaRepository = tipTerminaRepository;
    }

@Override
public TerminDto toDto(TerminEntity e) {
    if(e.getOdobrioKorisnik() == null){
        return new TerminDto(
            e.getTerminId(),
            e.getDatumVremePocetka(),
            e.getDatumVremeKraja(),
            e.getNaziv(),
            e.getOpis(),
            Math.toIntExact(e.getSala().getSalaId()),
            Math.toIntExact(e.getZahtevaoKorisnik().getKorisnikId()),
            e.getTipTermina().getTipTerminaId()
        );
    } else {
        return new TerminDto(
            e.getTerminId(),
            e.getDatumVremePocetka(),
            e.getDatumVremeKraja(),
            e.getNaziv(),
            e.getOpis(),
            Math.toIntExact(e.getSala().getSalaId()),
            Math.toIntExact(e.getZahtevaoKorisnik().getKorisnikId()),
            Math.toIntExact(e.getOdobrioKorisnik().getKorisnikId()),
            e.getTipTermina().getTipTerminaId()
        );
    }
}
    public TerminDto toDtoWithDetails(TerminEntity e) {
        TerminDto dto = toDto(e);

        dto.setSala(new SalaDto(
            e.getSala().getSalaId(),
            e.getSala().getNaziv(),
            e.getSala().getKapacitet()
        ));

        KorisnikEntity zk = e.getZahtevaoKorisnik();
        dto.setZahtevaoKorisnik(new KorisnikDto(
            zk.getKorisnikId(),
            zk.getEmail(),
            zk.getIme(),
            zk.getPrezime(),
            zk.getUloga(),
            null
        ));

        dto.setTipTermina(new TipTerminaDto(
            e.getTipTermina().getNazivTipa()
        ));

        return dto;
    }

    @Override

    public TerminEntity toEntity(TerminDto dto) {

        TerminEntity entity = new TerminEntity();

        entity.setDatumVremePocetka(dto.getDatumVremePocetka());
        entity.setDatumVremeKraja(dto.getDatumVremeKraja());
        entity.setNaziv(dto.getNaziv());
        entity.setOpis(dto.getOpis());

        entity.setSala(
            salaRepository.findById(dto.getSalaId())
                .orElseThrow(() -> new RuntimeException("Sala not found"))
        );
        
        entity.setZahtevaoKorisnik(
            korisnikRepository.findById(dto.getZahtevaoKorisnikId())
                .orElseThrow(() -> new RuntimeException("Korisnik not found"))
        );

        if(dto.getOdobrioKorisnikId() != null){
            entity.setOdobrioKorisnik(
                korisnikRepository.findById(dto.getOdobrioKorisnikId())
                    .orElseThrow(() -> new RuntimeException("Korisnik not found"))
            );            
        }
        
        entity.setTipTermina(
            tipTerminaRepository.findById(dto.getTipTerminaId())
                .orElseThrow(() -> new RuntimeException("TipTermina not found"))
        );
        

        entity.setDatumVremeOdobrenjaZahteva(dto.getDatumVremeOdobrenjaZahteva());

        return entity;
    }
    
}
