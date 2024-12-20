package com.enicarthage.FootballCompetition.football.controller;

import com.enicarthage.FootballCompetition.football.dto.CompetitionDTO;
import com.enicarthage.FootballCompetition.football.service.CompetitionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/competitions", produces = MediaType.APPLICATION_JSON_VALUE)
public class CompetitionController {
    
    @Autowired
    private CompetitionService competitionService;
    
    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CompetitionDTO> createCompetition(@RequestBody CompetitionDTO competitionDTO) {
        return ResponseEntity.ok(competitionService.createCompetition(competitionDTO));
    }
    
    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CompetitionDTO> getCompetition(@PathVariable Long id) {
        return ResponseEntity.ok(competitionService.getCompetition(id));
    }
    
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<CompetitionDTO>> getAllCompetitions() {
        return ResponseEntity.ok(competitionService.getAllCompetitions());
    }
    
    @PutMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CompetitionDTO> updateCompetition(@PathVariable Long id, 
                                                          @RequestBody CompetitionDTO competitionDTO) {
        return ResponseEntity.ok(competitionService.updateCompetition(id, competitionDTO));
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCompetition(@PathVariable Long id) {
        competitionService.deleteCompetition(id);
        return ResponseEntity.ok().build();
    }
    
    @GetMapping(value = "/country/{country}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<CompetitionDTO>> getCompetitionsByCountry(@PathVariable String country) {
        return ResponseEntity.ok(competitionService.findByCountry(country));
    }
}
