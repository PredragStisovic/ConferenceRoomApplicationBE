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
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.time.LocalDateTime;

/**
 *
 * @author predrag
 */
@Entity
@Table(name = "nedostupnost_sale")
public class NedostupnostSaleEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "nedostupnost_sale_id")
    private long nedostupnostSaleId;
    
    @Column
    private String razlog;
    
    @Column(name = "datum_vreme_od", nullable = false)
    private LocalDateTime datumVremeOd;
    
    @Column(name = "datum_vreme_do", nullable = false)
    private LocalDateTime datumVremeDo;
    
    @ManyToOne
    @JoinColumn(name = "sala_id", nullable = false)
    private SalaEntity sala;

    public NedostupnostSaleEntity(String razlog, LocalDateTime datumVremeOd, LocalDateTime datumVremeDo, SalaEntity sala) {
        this.razlog = razlog;
        this.datumVremeOd = datumVremeOd;
        this.datumVremeDo = datumVremeDo;
        this.sala = sala;
    }

    public NedostupnostSaleEntity() {
    }

    public long getNedostupnostSaleId() {
        return nedostupnostSaleId;
    }

    public String getRazlog() {
        return razlog;
    }

    public void setRazlog(String razlog) {
        this.razlog = razlog;
    }

    public LocalDateTime getDatumVremeOd() {
        return datumVremeOd;
    }

    public void setDatumVremeOd(LocalDateTime datumVremeOd) {
        this.datumVremeOd = datumVremeOd;
    }

    public LocalDateTime getDatumVremeDo() {
        return datumVremeDo;
    }

    public void setDatumVremeDo(LocalDateTime datumVremeDo) {
        this.datumVremeDo = datumVremeDo;
    }

    public SalaEntity getSala() {
        return sala;
    }

    public void setSala(SalaEntity sala) {
        this.sala = sala;
    }
    
    
    
    
    
    
}
