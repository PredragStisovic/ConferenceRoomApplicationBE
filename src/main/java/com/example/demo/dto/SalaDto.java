/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.dto;

import com.example.demo.domain.NedostupnostSaleEntity;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.util.List;

/**
 *
 * @author predrag
 */
public class SalaDto {
    private long id;
    
    @NotBlank(message = "Naziv sale je obavezan")
    private String naziv;

    @Min(value = 1, message = "Kapacitet mora biti najmanje 1")
    private int kapacitet;
    
    private List<NedostupnostSaleDto> nedostupnostiSale;

    public SalaDto() {
    }

    public SalaDto(String naziv, int kapacitet) {
        this.naziv = naziv;
        this.kapacitet = kapacitet;
    }

    public SalaDto(long id, String naziv, int kapacitet) {
        this.id = id;
        this.naziv = naziv;
        this.kapacitet = kapacitet;
    }

    public SalaDto(long id, String naziv, int kapacitet, List<NedostupnostSaleDto> nedostupnostiSale) {
        this.id = id;
        this.naziv = naziv;
        this.kapacitet = kapacitet;
        this.nedostupnostiSale = nedostupnostiSale;
    }
    
    
    
    

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public int getKapacitet() {
        return kapacitet;
    }

    public void setKapacitet(int kapacitet) {
        this.kapacitet = kapacitet;
    }

    public List<NedostupnostSaleDto> getNedostupnostiSale() {
        return nedostupnostiSale;
    }

    public void setNedostupnostiSale(List<NedostupnostSaleDto> nedostupnostiSale) {
        this.nedostupnostiSale = nedostupnostiSale;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

}
