package com.example.demo.controller;

import com.example.demo.dto.KorisnikDto;
import com.example.demo.dto.RegistracijaDto;
import com.example.demo.service.AuthService;
import com.example.demo.service.KorisnikService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import jakarta.validation.Valid;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

/**
 *
 * @author predrag
 */
@RestController
@RequestMapping("/korisnik")
public class KorisnikController {

    private final KorisnikService korisnikService;
    private final AuthService authService;

    public KorisnikController(KorisnikService korisnikService, AuthService authService) {
        this.korisnikService = korisnikService;
        this.authService = authService;
    }

    @GetMapping("/{korisnikId}")
    public ResponseEntity<KorisnikDto> getKorisnik(@PathVariable int korisnikId) {
        KorisnikDto dto = korisnikService.findKorisnikById(korisnikId);
        return ResponseEntity.ok(dto);
    }

    @PostMapping("/kreiraj")
    @PreAuthorize("hasAnyRole('ADMIN')")
    public ResponseEntity<KorisnikDto> kreirajKorisnika(@Valid @RequestBody RegistracijaDto dto) {
        KorisnikDto created = authService.registrujKorisnika(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(created);
    }
}
