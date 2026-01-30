/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.service.impl;

import com.example.demo.config.JWTConfig;
import com.example.demo.converter.impl.AuthDtoEntityConverter;
import com.example.demo.converter.impl.KorisnikDtoEntityConverter;
import com.example.demo.dao.KorisnikRepository;
import com.example.demo.domain.KorisnikEntity;
import com.example.demo.dto.KorisnikDto;
import com.example.demo.dto.PrijavaDto;
import com.example.demo.dto.RegistracijaDto;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import com.example.demo.service.AuthService;

/**
 *
 * @author predrag
 */
@Service
public class AuthServiceImpl implements AuthService{
    
    private KorisnikRepository korisnikRepository;
    private AuthDtoEntityConverter authConverter;
    private KorisnikDtoEntityConverter korisnikConverter;
    private PasswordEncoder passwordEncoder;
    private JWTConfig JwtConfig;
    
    @Autowired
    public AuthServiceImpl(
            KorisnikRepository korisnikRepository,
            PasswordEncoder passwordEncoder, 
            AuthDtoEntityConverter authConverter,
            KorisnikDtoEntityConverter korisnikConverter,
            JWTConfig JwtConfig
    ){
       this.korisnikRepository = korisnikRepository;
       this.passwordEncoder = passwordEncoder;
       this.authConverter = authConverter;
       this.korisnikConverter = korisnikConverter;
       this.JwtConfig = JwtConfig;
    }
    

    @Override
    public KorisnikDto registrujKorisnika(RegistracijaDto dto) {
        Optional<KorisnikEntity> postojeciKorisnik = korisnikRepository.nadjiPoMejlu(dto.getEmail());
        
        if(postojeciKorisnik.isPresent()){
            throw new ResponseStatusException(HttpStatus.FORBIDDEN, "Vec postoji korisnik sa ovom email adresom");
        }
        
        KorisnikEntity korisnik = authConverter.toEntity(dto);
        korisnik.setSifra(passwordEncoder.encode(dto.getSifra()));
        KorisnikEntity registrovanKorisnik = korisnikRepository.save(korisnik);
        
        return korisnikConverter.toDto(registrovanKorisnik);
    }

    @Override
    public KorisnikDto prijaviKorisnika(PrijavaDto dto) {
        Optional<KorisnikEntity> postojeciKorisnik = korisnikRepository.nadjiPoMejlu(dto.getEmail());
        
        if(postojeciKorisnik.isPresent()){
            KorisnikEntity korisnik = postojeciKorisnik.get();
            if(!passwordEncoder.matches(dto.getSifra(), korisnik.getSifra())){
                throw new ResponseStatusException(HttpStatus.FORBIDDEN, "Ne postoji korisnik sa ovim korisničkim imenom ili šifrom");
            }
            String token = JwtConfig.generisiToken(String.valueOf(korisnik.getKorisnikId()));
            KorisnikDto dtoToReturn = new KorisnikDto(korisnik.getEmail(), token, korisnik.getIme(), korisnik.getPrezime(), korisnik.getUloga());
            return dtoToReturn;
        } else {
            throw new ResponseStatusException(HttpStatus.FORBIDDEN, "Ne postoji korisnik sa ovim korisničkim imenom ili šifrom");
        }
    }
    
}
