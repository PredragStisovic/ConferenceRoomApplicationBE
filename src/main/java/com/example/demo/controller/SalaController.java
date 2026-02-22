/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.controller;

import com.example.demo.dto.FilterSalaDto;
import com.example.demo.dto.SalaDto;
import com.example.demo.service.SalaService;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author predrag
 */
@RestController
@RequestMapping("/sala")
public class SalaController {
    private final SalaService salaService;
    
    public SalaController(SalaService salaService){
        this.salaService = salaService;
    }
    
    @PostMapping("/filterAll")
    public ResponseEntity<List<SalaDto>> filtrirajSale(@RequestBody FilterSalaDto body){
        List<SalaDto> sale = this.salaService.filtrirajSale(body);
        return ResponseEntity.status(HttpStatus.OK).body(sale);
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<SalaDto> nadjiSaluPoIdu(@PathVariable("id") int salaId) {
        SalaDto sala = this.salaService.pronadjiSaluPoIdu(salaId);
        return ResponseEntity.status(HttpStatus.OK).body(sala);
    }
    
    @PostMapping("/create")
    public ResponseEntity<SalaDto> kreirajSalu(@RequestBody SalaDto body) {
        SalaDto kreiranaSala = this.salaService.kreirajSalu(body);
        return ResponseEntity.status(HttpStatus.CREATED).body(kreiranaSala);
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity obrisiSalu(@PathVariable("id") int salaId) {
        this.salaService.obrisiSalu(salaId);
        return ResponseEntity.ok().build();
    }
    

}
