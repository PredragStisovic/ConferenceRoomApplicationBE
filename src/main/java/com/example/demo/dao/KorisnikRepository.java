/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import com.example.demo.domain.KorisnikEntity;
import java.util.Optional;

/**
 *
 * @author predrag
 */
public interface KorisnikRepository extends JpaRepository<KorisnikEntity, Integer>{
    
    @Query("SELECT k FROM KorisnikEntity k WHERE k.email = ?1")
    Optional<KorisnikEntity> nadjiPoMejlu(String email);

}
