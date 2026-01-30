/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.service;

import com.example.demo.dto.SalaDto;
import java.util.List;

/**
 *
 * @author predrag
 */
public interface SalaService {
    SalaDto pronadjiSaluPoIdu(int salaId);
    List<SalaDto> vratiSveSale();
    SalaDto kreirajSalu(SalaDto salaDto);
    void obrisiSalu(int salaId);
}
