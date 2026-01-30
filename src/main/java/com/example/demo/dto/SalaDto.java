/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.dto;

import com.example.demo.domain.NedostupnostSale;
import java.util.List;

/**
 *
 * @author predrag
 */
public class SalaDto {
    private String naziv;
    
    private int kapacitet;
    
    private List<NedostupnostSale> nedostupnostiSale;

    public SalaDto() {
    }

    public SalaDto(String naziv, int kapacitet) {
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

    public List<NedostupnostSale> getNedostupnostiSale() {
        return nedostupnostiSale;
    }

    public void setNedostupnostiSale(List<NedostupnostSale> nedostupnostiSale) {
        this.nedostupnostiSale = nedostupnostiSale;
    }
    
    
}
