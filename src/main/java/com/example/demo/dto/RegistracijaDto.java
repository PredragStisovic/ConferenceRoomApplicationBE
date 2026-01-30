/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.dto;

import com.example.demo.domain.UlogaEnum;
import jakarta.annotation.Nullable;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

/**
 *
 * @author predrag
 */
public class RegistracijaDto {
    @NotNull(message="Morate uneti email")
    @Email
    private String email;
    
    @NotNull(message="Morate uneti sifru")
    @Size(min = 8, message = "Sifra mora imati minimum 8 karaktera")
    private String sifra;
    
    @NotNull(message="Morate uneti ime")
    @Size(min = 2, max = 50, message = "Ime mora biti u granicama velicine")
    private String ime;
    
    @NotNull(message="Morate uneti prezime")
    @Size(min = 2, max = 50, message = "Prezime mora biti u granicama velicine")
    private String prezime;
    
    @Nullable
    private UlogaEnum uloga;

    public RegistracijaDto() {
    }

    public UlogaEnum getUloga() {
        return uloga;
    }

    public void setUloga(UlogaEnum uloga) {
        this.uloga = uloga;
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
    
    
}
