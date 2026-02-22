/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.controller;

import com.example.demo.dto.NedostupnostSaleDto;
import com.example.demo.service.NedostupnostSaleService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;

/**
 *
 * @author predrag
 */
@RestController
@RequestMapping("/nedostupnost-sale")
public class NedostupnostSaleController {
    
    private final NedostupnostSaleService service;

    public NedostupnostSaleController(NedostupnostSaleService service) {
        this.service = service;
    }
  
    
    @PostMapping()
    public ResponseEntity<NedostupnostSaleDto> kreirajNedostupnostSale(@RequestBody NedostupnostSaleDto body){
        NedostupnostSaleDto kreiranaNedostupnostSale = this.service.kreirajNedostupnostSale(body);
        return ResponseEntity.status(HttpStatus.CREATED).body(kreiranaNedostupnostSale);
    }
}
