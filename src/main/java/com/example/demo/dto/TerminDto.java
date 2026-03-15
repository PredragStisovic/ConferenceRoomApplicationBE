/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.dto;

import jakarta.validation.constraints.NotBlank;
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

    @NotBlank(message = "Naziv termina je obavezan")
    private String naziv;

    private String opis;

    private int salaId;

    private int zahtevaoKorisnikId;

    private Integer odobrioKorisnikId;

    private int tipTerminaId;

    private LocalDateTime datumVremeOdobrenjaZahteva;

    private SalaDto sala;

    private KorisnikDto zahtevaoKorisnik;

    private TipTerminaDto tipTermina;

    public TerminDto() {
    }

    public TerminDto(long terminId, LocalDateTime datumVremePocetka, LocalDateTime datumVremeKraja, String naziv, String opis, int salaId, int zahtevaoKorisnikId, int odobrioKorisnikId, int tipTerminaId) {
        this.terminId = terminId;
        this.datumVremePocetka = datumVremePocetka;
        this.datumVremeKraja = datumVremeKraja;
        this.naziv = naziv;
        this.opis = opis;
        this.salaId = salaId;
        this.zahtevaoKorisnikId = zahtevaoKorisnikId;
        this.odobrioKorisnikId = odobrioKorisnikId;
        this.tipTerminaId = tipTerminaId;
    }
    
    public TerminDto(long terminId, LocalDateTime datumVremePocetka, LocalDateTime datumVremeKraja, String naziv, String opis, int salaId, int zahtevaoKorisnikId, int tipTerminaId) {
        this.terminId = terminId;
        this.datumVremePocetka = datumVremePocetka;
        this.datumVremeKraja = datumVremeKraja;
        this.naziv = naziv;
        this.opis = opis;
        this.salaId = salaId;
        this.zahtevaoKorisnikId = zahtevaoKorisnikId;
        this.tipTerminaId = tipTerminaId;
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

    public int getSalaId() {
        return salaId;
    }

    public void setSalaId(int salaId) {
        this.salaId = salaId;
    }

    public int getZahtevaoKorisnikId() {
        return zahtevaoKorisnikId;
    }

    public void setZahtevaoKorisnikId(int zahtevaoKorisnikId) {
        this.zahtevaoKorisnikId = zahtevaoKorisnikId;
    }

    public Integer getOdobrioKorisnikId() {
        return odobrioKorisnikId;
    }

    public void setOdobrioKorisnikId(int odobrioKorisnikId) {
        this.odobrioKorisnikId = odobrioKorisnikId;
    }

    public int getTipTerminaId() {
        return tipTerminaId;
    }

    public void setTipTerminaId(int tipTerminaId) {
        this.tipTerminaId = tipTerminaId;
    }


    public LocalDateTime getDatumVremeOdobrenjaZahteva() {
        return datumVremeOdobrenjaZahteva;
    }

    public void setDatumVremeOdobrenjaZahteva(LocalDateTime datumVremeOdobrenjaZahteva) {
        this.datumVremeOdobrenjaZahteva = datumVremeOdobrenjaZahteva;
    }

    public SalaDto getSala() {
        return sala;
    }

    public void setSala(SalaDto sala) {
        this.sala = sala;
    }

    public KorisnikDto getZahtevaoKorisnik() {
        return zahtevaoKorisnik;
    }

    public void setZahtevaoKorisnik(KorisnikDto zahtevaoKorisnik) {
        this.zahtevaoKorisnik = zahtevaoKorisnik;
    }

    public TipTerminaDto getTipTermina() {
        return tipTermina;
    }

    public void setTipTermina(TipTerminaDto tipTermina) {
        this.tipTermina = tipTermina;
    }

}
