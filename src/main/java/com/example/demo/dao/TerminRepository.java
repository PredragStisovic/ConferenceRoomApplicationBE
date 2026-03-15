/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.dao;

import com.example.demo.domain.TerminEntity;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 *
 * @author predrag
 */
public interface TerminRepository extends JpaRepository<TerminEntity, Integer>{
    @Query("SELECT t FROM TerminEntity t WHERE t.sala.salaId = ?1")
    List<TerminEntity> findAllTerminiBySalaId(int salaId);
    
    @Query("SELECT t FROM TerminEntity t LEFT JOIN FETCH t.tipTermina LEFT JOIN FETCH t.sala LEFT JOIN FETCH t.zahtevaoKorisnik WHERE t.odobrioKorisnik IS NULL")
    List<TerminEntity> findAllNeodobreniTermini();
    
}
