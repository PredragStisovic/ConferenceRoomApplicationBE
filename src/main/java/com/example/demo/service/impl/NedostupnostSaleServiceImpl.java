/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.service.impl;

import com.example.demo.converter.impl.NedostupnostSaleConverter;
import com.example.demo.dao.NedostupnostSaleRepository;
import com.example.demo.domain.NedostupnostSaleEntity;
import com.example.demo.dto.NedostupnostSaleDto;
import com.example.demo.service.NedostupnostSaleService;
import java.time.LocalDateTime;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

/**
 *
 * @author predrag
 */
@Service
public class NedostupnostSaleServiceImpl implements NedostupnostSaleService{
    
    private final NedostupnostSaleRepository repository;
    private final NedostupnostSaleConverter converter;

    public NedostupnostSaleServiceImpl(NedostupnostSaleRepository repository, NedostupnostSaleConverter converter) {
        this.repository = repository;
        this.converter = converter;
    }

    @Override
    public NedostupnostSaleDto kreirajNedostupnostSale(NedostupnostSaleDto dto) {
        if (dto.getRazlog() == null || dto.getRazlog().trim().isEmpty()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Razlog nedostupnosti je obavezan");
        }
        if (dto.getDatumVremeOd().isAfter(dto.getDatumVremeDo()) || dto.getDatumVremeOd().isEqual(dto.getDatumVremeDo())) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Datum početka mora biti pre datuma završetka");
        }
        if (dto.getDatumVremeOd().isBefore(LocalDateTime.now())) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Datum početka ne može biti u prošlosti");
        }
        NedostupnostSaleEntity nedostupnostSaleEntitetZaKreiranje = converter.toEntity(dto);
        NedostupnostSaleEntity kreiranaNedostupnostSale = repository.save(nedostupnostSaleEntitetZaKreiranje);
        return converter.toDto(kreiranaNedostupnostSale);
    }
    
}
