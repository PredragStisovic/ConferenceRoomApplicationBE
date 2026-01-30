/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.dto;

import com.example.demo.domain.UlogaEnum;
import jakarta.validation.constraints.Email;

/**
 *
 * @author predrag
 */
public class KorisnikDto {
    private long korisnikId;
    
    @Email
    private String email;
    
    private String sifra;
    
    private String ime;
    
    private String prezime;
    
    private UlogaEnum uloga;
    
    private String token;

    public KorisnikDto(long korisnikId, String email, String sifra, String ime, String prezime, UlogaEnum uloga) {
        this.korisnikId = korisnikId;
        this.email = email;
        this.sifra = sifra;
        this.ime = ime;
        this.prezime = prezime;
        this.uloga = uloga;
    }
    
    public KorisnikDto(String email, String token, String ime, String prezime, UlogaEnum uloga) {
        this.token = token;
        this.email = email;
        this.ime = ime;
        this.prezime = prezime;
        this.uloga = uloga;
    }

    public KorisnikDto() {
    }

    public long getKorisnikId() {
        return korisnikId;
    }

    public void setKorisnikId(long korisnikId) {
        this.korisnikId = korisnikId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSifra() {
        return sifra;
    }

    public void setSifra(String sifra) {
        this.sifra = sifra;
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

    public UlogaEnum getUloga() {
        return uloga;
    }

    public void setUloga(UlogaEnum uloga) {
        this.uloga = uloga;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
    
    
    
}
