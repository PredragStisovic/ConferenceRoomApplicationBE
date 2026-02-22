/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.dto;

import com.example.demo.domain.NedostupnostSaleEntity;
import jakarta.validation.constraints.NotNull;
import java.util.List;

/**
 *
 * @author predrag
 */
public class SalaDto {
    private long id;
    
    @NotNull
    private String naziv;
    
    @NotNull
    private int kapacitet;
    
    private List<NedostupnostSaleEntity> nedostupnostiSale;

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

    public List<NedostupnostSaleEntity> getNedostupnostiSale() {
        return nedostupnostiSale;
    }

    public void setNedostupnostiSale(List<NedostupnostSaleEntity> nedostupnostiSale) {
        this.nedostupnostiSale = nedostupnostiSale;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

}
