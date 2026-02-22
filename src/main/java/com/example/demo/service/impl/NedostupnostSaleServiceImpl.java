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
import org.springframework.stereotype.Service;

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
        NedostupnostSaleEntity nedostupnostSaleEntitetZaKreiranje = converter.toEntity(dto);
        NedostupnostSaleEntity kreiranaNedostupnostSale = repository.save(nedostupnostSaleEntitetZaKreiranje);
        return converter.toDto(kreiranaNedostupnostSale);
    }
    
}
