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
@Table(name = "tip_termina")
public class TipTerminaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "tip_termina_id")
    private int tipTerminaId;
    
    @Column(name = "naziv_tipa")
    private String nazivTipa;   
   
    @OneToMany(mappedBy = "tipTermina")
    private List<TerminEntity> termini = new ArrayList();

    public TipTerminaEntity(int tipTerminaId, String nazivTipa, TerminEntity termin) {
        this.tipTerminaId = tipTerminaId;
        this.nazivTipa = nazivTipa;
    }

    public TipTerminaEntity() {
    }

    public int getTipTerminaId() {
        return tipTerminaId;
    }

    public void setTipTerminaId(int tipTerminaId) {
        this.tipTerminaId = tipTerminaId;
    }

    public String getNazivTipa() {
        return nazivTipa;
    }

    public void setNazivTipa(String nazivTipa) {
        this.nazivTipa = nazivTipa;
    }
}
