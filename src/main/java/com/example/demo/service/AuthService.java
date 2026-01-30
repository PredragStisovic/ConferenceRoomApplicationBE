/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.service;

import com.example.demo.dto.KorisnikDto;
import com.example.demo.dto.PrijavaDto;
import com.example.demo.dto.RegistracijaDto;

/**
 *
 * @author predrag
 */
public interface AuthService {
   
    KorisnikDto registrujKorisnika(RegistracijaDto dto);
    
    KorisnikDto prijaviKorisnika(PrijavaDto dto);
}
