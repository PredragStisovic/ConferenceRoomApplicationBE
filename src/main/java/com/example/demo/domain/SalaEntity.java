/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author predrag
 */
@Entity
@Table(name = "sale")
public class SalaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "sala_id")
    private long salaId;
    
    @Column(nullable = false)
    private String naziv;
    
    @Column(nullable = false)
    private int kapacitet;
    
    @OneToMany(mappedBy = "sala")
    private List<TerminEntity> termini = new ArrayList<>();
    
    @OneToMany(mappedBy = "sala")
    private List<NedostupnostSale> nedostupnostSale = new ArrayList<>();

    public List<NedostupnostSale> getNedostupnostSale() {
        return nedostupnostSale;
    }

    public void setNedostupnostSale(List<NedostupnostSale> nedostupnostSale) {
        this.nedostupnostSale = nedostupnostSale;
    }

    public SalaEntity(String naziv, int kapacitet) {
        this.naziv = naziv;
        this.kapacitet = kapacitet;
    }

    public SalaEntity() {
    }

    public long getSalaId() {
        return salaId;
    }

    public void setSalaId(long salaId) {
        this.salaId = salaId;
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

    public List<TerminEntity> getTermini() {
        return termini;
    }

    public void setTermini(List<TerminEntity> termini) {
        this.termini = termini;
    }
    
}
