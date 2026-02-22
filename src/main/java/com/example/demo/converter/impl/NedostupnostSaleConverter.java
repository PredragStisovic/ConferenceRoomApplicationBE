/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.converter.impl;

import com.example.demo.converter.Converter;
import com.example.demo.dao.SalaRepository;
import com.example.demo.domain.NedostupnostSaleEntity;
import com.example.demo.domain.SalaEntity;
import com.example.demo.dto.NedostupnostSaleDto;
import java.time.LocalDateTime;
import java.util.Optional;
import org.springframework.stereotype.Component;

/**
 *
 * @author predrag
 */
@Component
public class NedostupnostSaleConverter implements Converter<NedostupnostSaleDto, NedostupnostSaleEntity>{
    
    private final SalaRepository salaRepository;

    public NedostupnostSaleConverter(SalaRepository salaRepository) {
        this.salaRepository = salaRepository;
    }
    
    

    @Override
    public NedostupnostSaleDto toDto(NedostupnostSaleEntity e) {
        NedostupnostSaleDto dto = new NedostupnostSaleDto(e.getSala().getSalaId(), e.getRazlog(), e.getDatumVremeOd(), e.getDatumVremeDo());
        return dto;
    }

    @Override
    public NedostupnostSaleEntity toEntity(NedostupnostSaleDto t) {
        Optional<SalaEntity> sala = salaRepository.findById((int)t.getSalaId());
        if(sala.isEmpty()){
            throw new IllegalArgumentException("Sala with this id does not exist");
        } else {
            SalaEntity salaToSave = sala.get();
            NedostupnostSaleEntity entity = new NedostupnostSaleEntity(t.getRazlog(), t.getDatumVremeOd(), t.getDatumVremeDo(), salaToSave);
            return entity;
        }
    }
    
}
