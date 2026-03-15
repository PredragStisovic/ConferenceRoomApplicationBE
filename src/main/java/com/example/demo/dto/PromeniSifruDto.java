package com.example.demo.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class PromeniSifruDto {
    @NotNull(message = "Morate uneti trenutnu sifru")
    private String staraSifra;

    @NotNull(message = "Morate uneti novu sifru")
    @Size(min = 8, message = "Sifra mora imati minimum 8 karaktera")
    private String novaSifra;

    public PromeniSifruDto() {
    }

    public String getStaraSifra() {
        return staraSifra;
    }

    public void setStaraSifra(String staraSifra) {
        this.staraSifra = staraSifra;
    }

    public String getNovaSifra() {
        return novaSifra;
    }

    public void setNovaSifra(String novaSifra) {
        this.novaSifra = novaSifra;
    }
}
