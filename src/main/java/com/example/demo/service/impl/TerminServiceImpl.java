/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.service.impl;

import com.example.demo.converter.impl.TerminDtoEntityConverter;
import com.example.demo.dao.KorisnikRepository;
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
    private final KorisnikRepository korisnikRepository;

    public TerminServiceImpl(TerminRepository repository, TerminDtoEntityConverter converter, KorisnikRepository korisnikRepository) {
        this.repository = repository;
        this.converter = converter;
        this.korisnikRepository = korisnikRepository;
    }
    
    
    
    @Override
    public TerminDto createTermin(TerminDto dto) {
        if (dto.getNaziv() == null || dto.getNaziv().trim().isEmpty()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Naziv termina je obavezan");
        }
        if (dto.getDatumVremePocetka().isAfter(dto.getDatumVremeKraja()) || dto.getDatumVremePocetka().isEqual(dto.getDatumVremeKraja())) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Datum početka mora biti pre datuma završetka");
        }
        if (dto.getDatumVremePocetka().isBefore(LocalDateTime.now())) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Ne možete zakazati termin u prošlosti");
        }
        if (dto.getTipTerminaId() <= 0) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Tip termina je obavezan");
        }
        TerminEntity terminEntityToCreate = converter.toEntity(dto);
        TerminEntity createdTermin = repository.save(terminEntityToCreate);
        return converter.toDto(createdTermin);
    }

    @Override
    public List<TerminDto> getAllTerminiBySalaId(int salaId) {
        List<TerminEntity> termini = repository.findAllTerminiBySalaId(salaId);
        if(termini.size() == 0){
            return new ArrayList<TerminDto>();
        }
        List<TerminDto> terminiDto = new ArrayList<TerminDto>();
        for (TerminEntity terminEntity : termini) {
            terminiDto.add(converter.toDto(terminEntity));
        }
        return terminiDto;
    }
    
    @Override
    public List<TerminDto> getAllNeodobreniTermini() {
        List<TerminEntity> termini = repository.findAllNeodobreniTermini();
        if(termini.size() == 0){
            return new ArrayList<TerminDto>();
        }
        List<TerminDto> terminiDto = new ArrayList<TerminDto>();
        for (TerminEntity terminEntity : termini) {
            terminiDto.add(converter.toDtoWithDetails(terminEntity));
        }
        return terminiDto;
    }

    @Override
    public TerminDto approveTermin(int terminId, int approvedById) {
        Optional<TerminEntity> foundTermin= repository.findById(terminId);
        if(!foundTermin.isPresent()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Ne postoji termin za odobravanje");
        }
        TerminEntity terminToUpdate = foundTermin.get();
        Optional<KorisnikEntity> foundKorisnik = korisnikRepository.findById(approvedById);
        if(foundKorisnik.isPresent()){
            KorisnikEntity approver = foundKorisnik.get();
            if(approver.getKorisnikId() == terminToUpdate.getZahtevaoKorisnik().getKorisnikId()){
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Korisnik koji je kreirao zahtev ne moze da ga odobri");
            }
            terminToUpdate.setOdobrioKorisnik(foundKorisnik.get());    
        }
        
        terminToUpdate.setDatumVremeOdobrenjaZahteva(LocalDateTime.now());
        repository.save(terminToUpdate);
        return converter.toDto(terminToUpdate);
    }

    @Override
    public TerminDto removeTermin(int terminId) {
        Optional<TerminEntity> foundTermin = repository.findById(terminId);
        if (!foundTermin.isPresent()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Ne postoji termin za brisanje");
        }
        TerminEntity terminToDelete = foundTermin.get();
        TerminDto deletedTerminDto = converter.toDto(terminToDelete);
        repository.delete(terminToDelete);
        return deletedTerminDto;
    }

}
