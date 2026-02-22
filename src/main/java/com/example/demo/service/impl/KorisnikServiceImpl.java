/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.service.impl;

import com.example.demo.converter.impl.KorisnikDtoEntityConverter;
import com.example.demo.dao.KorisnikRepository;
import com.example.demo.domain.KorisnikEntity;
import com.example.demo.dto.KorisnikDto;
import com.example.demo.service.KorisnikService;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

/**
 *
 * @author predrag
 */
@Service
public class KorisnikServiceImpl implements KorisnikService{
    
    private KorisnikRepository korisnikRepository;
    private KorisnikDtoEntityConverter converter;
    
    @Autowired
    public KorisnikServiceImpl(KorisnikRepository korisnikRepository, KorisnikDtoEntityConverter converter){
        this.korisnikRepository = korisnikRepository;
        this.converter = converter;
    }

    @Override
    public KorisnikDto findKorisnikById(int korisnikId) {
        Optional<KorisnikEntity> foundKorisnik = korisnikRepository.findById(korisnikId);
        if(!foundKorisnik.isPresent()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Ne postoji korisnik sa ovim ID-em");
        }
        KorisnikEntity korisnik = foundKorisnik.get();
        return converter.toDto(korisnik);
    }
    
}
