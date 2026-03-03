/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.controller;

import com.example.demo.domain.KorisnikEntity;
import com.example.demo.dto.KorisnikDto;
import com.example.demo.dto.TerminDto;
import com.example.demo.service.TerminService;
import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 *
 * @author predrag
 */
@RestController
@RequestMapping("/termin")
public class TerminController {
    private final TerminService terminService;

    public TerminController(TerminService terminService) {
        this.terminService = terminService;
    }

    @PostMapping()
    public ResponseEntity<TerminDto> createTermin(@RequestBody TerminDto dto) {
        TerminDto created = terminService.createTermin(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(created);
    }

    @GetMapping("/neodobreni-termini")
    public ResponseEntity<List<TerminDto>> getAllNeodobreniTermini() {
        List<TerminDto> termini = terminService.getAllNeodobreniTermini();
        return ResponseEntity.ok(termini);
    }

    @GetMapping("/sala/{salaId}")
    public ResponseEntity<List<TerminDto>> getAllTerminiBySalaId(@PathVariable("salaId") int salaId) {
        List<TerminDto> termini = terminService.getAllTerminiBySalaId(salaId);
        return ResponseEntity.ok(termini);
    }

    @PutMapping("/approve-termin/{terminId}")
    public ResponseEntity<TerminDto> approveTermin(
            @PathVariable int terminId,
            @RequestBody TerminDto body) {
        KorisnikEntity approvedBy = body.getOdobrioKorisnik();
        TerminDto approvedTermin = terminService.approveTermin(terminId, approvedBy);
        return ResponseEntity.ok(approvedTermin);
    }
}
