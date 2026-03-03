/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.example.demo.service;

import com.example.demo.domain.KorisnikEntity;
import com.example.demo.dto.TerminDto;
import java.util.List;

/**
 *
 * @author predrag
 */
public interface TerminService {
    TerminDto createTermin(TerminDto dto);
    List<TerminDto> getAllTerminiBySalaId(int salaId);
    List<TerminDto> getAllNeodobreniTermini();
    TerminDto approveTermin(int terminId, KorisnikEntity approvedBy);
}
