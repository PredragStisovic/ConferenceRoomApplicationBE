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
@Table(name = "termini")
public class TerminEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "termin_id")
    private long terminId;
    
    @Column(name = "datum_vreme_pocetka", nullable = false)
    private LocalDateTime datumVremePocetka;
    
    @Column(name = "datum_vreme_kraja", nullable = false)
    private LocalDateTime datumVremeKraja;
    
    @Column(nullable = false)
    private String svrha;
    
   
    @ManyToOne
    @JoinColumn(name = "sala_id", nullable = false)
    private SalaEntity sala;
    
    @ManyToOne
    @JoinColumn(name = "zahtevao_korisnik_id", nullable = false)
    private KorisnikEntity zahtevaoKorisnik;
    
    @ManyToOne
    @JoinColumn(name = "odobrio_korisnik_id", nullable = false)
    private KorisnikEntity odobrioKorisnik;
    
    @ManyToOne
    @JoinColumn(name = "tip_termina_id", nullable = false)
    private TipTerminaEntity tipTermina;
    
    public TerminEntity(LocalDateTime datumVremePocetka, LocalDateTime datumVremeKraja, String svrha, SalaEntity sala, KorisnikEntity zahtevaoKorisnik, KorisnikEntity odobrioKorisnik, TipTerminaEntity tipTermina) {
        this.datumVremePocetka = datumVremePocetka;
        this.datumVremeKraja = datumVremeKraja;
        this.svrha = svrha;
        this.sala = sala;
        this.zahtevaoKorisnik = zahtevaoKorisnik;
        this.odobrioKorisnik = odobrioKorisnik;
        this.tipTermina = tipTermina;
    }

    public TerminEntity() {
    }

    public long getTerminId() {
        return terminId;
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

    public String getSvrha() {
        return svrha;
    }

    public void setSvrha(String svrha) {
        this.svrha = svrha;
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
    
}
