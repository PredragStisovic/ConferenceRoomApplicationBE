/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.controller;

import com.example.demo.dto.KorisnikDto;
import com.example.demo.dto.PrijavaDto;
import com.example.demo.dto.PromeniSifruDto;
import com.example.demo.dto.RegistracijaDto;
import com.example.demo.service.KorisnikService;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import jakarta.validation.Valid;
import com.example.demo.service.AuthService;

/**
 *
 * @author predrag
 */
@RestController
@RequestMapping("/auth")
public class AuthController {

    private final AuthService authService;
    private final KorisnikService korisnikService;

    public AuthController(AuthService authService, KorisnikService korisnikService) {
        this.authService = authService;
        this.korisnikService = korisnikService;
    }

    @PostMapping("/register")
    public ResponseEntity<KorisnikDto> register(@Valid @RequestBody RegistracijaDto korisnik){
        KorisnikDto dto = authService.registrujKorisnika(korisnik);
        return ResponseEntity.status(HttpStatus.CREATED).body(dto);
    }

    @PostMapping("/login")
    public ResponseEntity<KorisnikDto> login(@RequestBody PrijavaDto korisnik){
        KorisnikDto dto = authService.prijaviKorisnika(korisnik);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PutMapping("/promeni-sifru/{korisnikId}")
    public ResponseEntity<Void> promeniSifru(
            @PathVariable int korisnikId,
            @Valid @RequestBody PromeniSifruDto dto) {
        korisnikService.promeniSifru(korisnikId, dto);
        return ResponseEntity.ok().build();
    }
}
