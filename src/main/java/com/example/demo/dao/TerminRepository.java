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
    @Query("SELECT * FROM termin t LEFT JOIN sala s ON t.salaId = s.id WHERE t.salaId = ?1")
    Optional<List<TerminEntity>> findAllTerminiBySalaId(int salaId);
    
    @Query("SELECT * FROM termin t WHERE t.odobrio_korisnik_id IS NULL")
    Optional<List<TerminEntity>> findAllNeodobreniTermini();
    
}
