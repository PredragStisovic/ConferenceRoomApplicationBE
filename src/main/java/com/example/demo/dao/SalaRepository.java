/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.dao;

import com.example.demo.domain.SalaEntity;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 *
 * @author predrag
 */
public interface SalaRepository extends JpaRepository<SalaEntity, Integer>{
        @Query("SELECT s FROM SalaEntity s WHERE s.salaId = ?1")
        Optional<SalaEntity> pronadjiPoIdu(int salaId);
}
