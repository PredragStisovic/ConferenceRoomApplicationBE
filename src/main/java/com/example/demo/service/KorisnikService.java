/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.service;

import com.example.demo.dto.KorisnikDto;
import com.example.demo.dto.PromeniSifruDto;

/**
 *
 * @author predrag
 */
public interface KorisnikService {
    public KorisnikDto findKorisnikById(int korisnikId);
    public void promeniSifru(int korisnikId, PromeniSifruDto dto);
}
