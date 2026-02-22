/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.dto;

import jakarta.validation.constraints.NotNull;
import java.time.LocalDateTime;

/**
 *
 * @author predrag
 */
public class NedostupnostSaleDto {
    @NotNull
    private long salaId;
    
    @NotNull
    private String razlog;
    
    @NotNull
    private LocalDateTime datumVremeOd;
    
    @NotNull
    private LocalDateTime datumVremeDo;

    public NedostupnostSaleDto() {
    }

    public NedostupnostSaleDto(long salaId, String razlog, LocalDateTime datumVremeOd, LocalDateTime datumVremeDo) {
        this.salaId = salaId;
        this.razlog = razlog;
        this.datumVremeOd = datumVremeOd;
        this.datumVremeDo = datumVremeDo;
    }

    public long getSalaId() {
        return salaId;
    }

    public void setSalaId(long salaId) {
        this.salaId = salaId;
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
    
    
    
}
