/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.dto;

import com.example.demo.domain.KorisnikEntity;
import com.example.demo.domain.SalaEntity;
import com.example.demo.domain.TipTerminaEntity;
import jakarta.validation.constraints.NotNull;
import java.time.LocalDateTime;

/**
 *
 * @author predrag
 */
public class TerminDto {
    private long terminId;
    @NotNull
    private LocalDateTime datumVremePocetka;
    @NotNull
    private LocalDateTime datumVremeKraja;
    
    private String naziv;
    
    private String opis;
    
    private SalaEntity sala;
    
    private KorisnikEntity zahtevaoKorisnik;
    
    private KorisnikEntity odobrioKorisnik;
    
    private TipTerminaEntity tipTermina;
    
    private LocalDateTime datumVremeOdobrenjaZahteva;

    public TerminDto() {
    }

    public TerminDto(long terminId, LocalDateTime datumVremePocetka, LocalDateTime datumVremeKraja, String naziv, String opis, SalaEntity sala, KorisnikEntity zahtevaoKorisnik, KorisnikEntity odobrioKorisnik, TipTerminaEntity tipTermina) {
        this.terminId = terminId;
        this.datumVremePocetka = datumVremePocetka;
        this.datumVremeKraja = datumVremeKraja;
        this.naziv = naziv;
        this.opis = opis;
        this.sala = sala;
        this.zahtevaoKorisnik = zahtevaoKorisnik;
        this.odobrioKorisnik = odobrioKorisnik;
        this.tipTermina = tipTermina;
    }

    public long getTerminId() {
        return terminId;
    }

    public void setTerminId(long terminId) {
        this.terminId = terminId;
    }

    public LocalDateTime getDatumVremePocetka() {
        return datumVremePocetka;
    }

    public void setDatumVremePocetka(LocalDateTime datumVremePocetka) {
        this.datumVremePocetka = datumVremePocetka;
    }

    public LocalDateTime getDatumVremeKraja() {
        return datumVremeKraja;
    }

    public void setDatumVremeKraja(LocalDateTime datumVremeKraja) {
        this.datumVremeKraja = datumVremeKraja;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public String getOpis() {
        return opis;
    }

    public void setOpis(String opis) {
        this.opis = opis;
    }

    public SalaEntity getSala() {
        return sala;
    }

    public void setSala(SalaEntity sala) {
        this.sala = sala;
    }

    public KorisnikEntity getZahtevaoKorisnik() {
        return zahtevaoKorisnik;
    }

    public void setZahtevaoKorisnik(KorisnikEntity zahtevaoKorisnik) {
        this.zahtevaoKorisnik = zahtevaoKorisnik;
    }

    public KorisnikEntity getOdobrioKorisnik() {
        return odobrioKorisnik;
    }

    public void setOdobrioKorisnik(KorisnikEntity odobrioKorisnik) {
        this.odobrioKorisnik = odobrioKorisnik;
    }

    public TipTerminaEntity getTipTermina() {
        return tipTermina;
    }

    public void setTipTermina(TipTerminaEntity tipTermina) {
        this.tipTermina = tipTermina;
    }

    public LocalDateTime getDatumVremeOdobrenjaZahteva() {
        return datumVremeOdobrenjaZahteva;
    }

    public void setDatumVremeOdobrenjaZahteva(LocalDateTime datumVremeOdobrenjaZahteva) {
        this.datumVremeOdobrenjaZahteva = datumVremeOdobrenjaZahteva;
    }
    
}
