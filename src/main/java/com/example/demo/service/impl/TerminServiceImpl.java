/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.service.impl;

import com.example.demo.converter.impl.TerminDtoEntityConverter;
import com.example.demo.dao.TerminRepository;
import com.example.demo.domain.KorisnikEntity;
import com.example.demo.domain.TerminEntity;
import com.example.demo.dto.TerminDto;
import com.example.demo.service.TerminService;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.http.HttpStatus;

/**
 *
 * @author predrag
 */
@Service
public class TerminServiceImpl implements TerminService {

    private final TerminRepository repository;
    private final TerminDtoEntityConverter converter;

    public TerminServiceImpl(TerminRepository repository, TerminDtoEntityConverter converter) {
        this.repository = repository;
        this.converter = converter;
    }
    
    
    
    @Override
    public TerminDto createTermin(TerminDto dto) {
        TerminEntity terminEntityToCreate = converter.toEntity(dto);
        TerminEntity createdTermin = repository.save(terminEntityToCreate);
        return converter.toDto(createdTermin);
    }

    @Override
    public List<TerminDto> getAllTerminiBySalaId(int salaId) {
        Optional<List<TerminEntity>> foundTermini = repository.findAllTerminiBySalaId(salaId);
        if(!foundTermini.isPresent()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Ne postoje termini za ovu salu");
        }
        List<TerminEntity> termini = foundTermini.get();
        List<TerminDto> terminiDto = new ArrayList<TerminDto>();
        for (TerminEntity terminEntity : termini) {
            terminiDto.add(converter.toDto(terminEntity));
        }
        return terminiDto;
    }
    
    @Override
    public List<TerminDto> getAllNeodobreniTermini() {
        Optional<List<TerminEntity>> foundTermini = repository.findAllNeodobreniTermini();
        if(!foundTermini.isPresent()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Ne postoje neodobreni termini");
        }
        List<TerminEntity> termini = foundTermini.get();
        List<TerminDto> terminiDto = new ArrayList<TerminDto>();
        for (TerminEntity terminEntity : termini) {
            terminiDto.add(converter.toDto(terminEntity));
        }
        return terminiDto;
    }

    @Override
    public TerminDto approveTermin(int terminId, KorisnikEntity approvedBy) {
        Optional<TerminEntity> foundTermin= repository.findById(terminId);
        if(!foundTermin.isPresent()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Ne postoji termin za odobravanje");
        }
        TerminEntity terminToUpdate = foundTermin.get();
        terminToUpdate.setOdobrioKorisnik(approvedBy);
        terminToUpdate.setDatumVremeOdobrenjaZahteva(LocalDateTime.now());
        repository.save(terminToUpdate);
        return converter.toDto(terminToUpdate);
    }
    
}
