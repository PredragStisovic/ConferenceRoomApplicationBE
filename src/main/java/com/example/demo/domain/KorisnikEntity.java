/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
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
@Table(name = "korisnici")
public class KorisnikEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "korisnik_id")
    private long korisnikId;
    
    @Column(nullable = false)
    private String sifra;
    
    @Column(nullable = false)
    private String ime;
    
    @Column(nullable = false)
    private String prezime;
    
    @Column(unique = true, nullable = false)
    private String email;
    
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private UlogaEnum uloga = UlogaEnum.ZAPOSLENI;
    
    @OneToMany(mappedBy = "zahtevaoKorisnik")
    private List<TerminEntity> zahtevaniTermini = new ArrayList<>();
    
    @OneToMany(mappedBy = "odobrioKorisnik")
    private List<TerminEntity> odobreniTermini = new ArrayList<>();

    public KorisnikEntity(String email, String ime, String prezime, UlogaEnum uloga) {
        this.email = email;
        this.ime = ime;
        this.prezime = prezime;
        this.uloga = uloga;
    }
    
    public KorisnikEntity(String email, String ime, String prezime) {
        this.email = email;
        this.ime = ime;
        this.prezime = prezime;
    }

    public List<TerminEntity> getZahtevaniTermini() {
        return zahtevaniTermini;
    }

    public void setZahtevaniTermini(List<TerminEntity> zahtevaniTermini) {
        this.zahtevaniTermini = zahtevaniTermini;
    }

    public List<TerminEntity> getOdobreniTermini() {
        return odobreniTermini;
    }

    public void setOdobreniTermini(List<TerminEntity> odobreniTermini) {
        this.odobreniTermini = odobreniTermini;
    }

    public KorisnikEntity() {
    }

    public long getKorisnikId() {
        return korisnikId;
    }

    public void setKorisnikId(long korisnikId) {
        this.korisnikId = korisnikId;
    }

    public String getSifra() {
        return sifra;
    }

    public void setSifra(String sifra) {
        this.sifra = sifra;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public UlogaEnum getUloga() {
        return uloga;
    }

    public void setUloga(UlogaEnum uloga) {
        this.uloga = uloga;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getPrezime() {
        return prezime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }
    
    
}
