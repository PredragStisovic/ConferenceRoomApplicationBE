/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.dao;

import com.example.demo.domain.SalaEntity;
import java.util.Optional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 *
 * @author predrag
 */
public interface SalaRepository extends JpaRepository<SalaEntity, Integer>{
        @Query("SELECT s FROM SalaEntity s WHERE s.salaId = ?1")
        Optional<SalaEntity> pronadjiPoIdu(int salaId);
        
        @Query("""
            SELECT s FROM SalaEntity s
            WHERE (:minimalCapacity IS NULL OR s.kapacitet >= :minimalCapacity)
              AND (:name IS NULL OR LOWER(s.naziv) LIKE LOWER(CONCAT('%', :name, '%')))
        """)
        Page<SalaEntity> findFiltered(
                @Param("minimalCapacity") Integer minimalCapacity,
                @Param("name") String name,
                Pageable pageable
        );
}
