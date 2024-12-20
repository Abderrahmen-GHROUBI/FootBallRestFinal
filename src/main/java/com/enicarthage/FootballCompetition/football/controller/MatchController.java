package com.enicarthage.FootballCompetition.football.controller;

import com.enicarthage.FootballCompetition.football.dto.MatchDTO;
import com.enicarthage.FootballCompetition.football.service.MatchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/matches", produces = MediaType.APPLICATION_JSON_VALUE)
public class MatchController {
    
    @Autowired
    private MatchService matchService;
    
    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<MatchDTO> createMatch(@RequestBody MatchDTO matchDTO) {
        return ResponseEntity.ok(matchService.createMatch(matchDTO));
    }
    
    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<MatchDTO> getMatch(@PathVariable Long id) {
        return ResponseEntity.ok(matchService.getMatch(id));
    }
    
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<MatchDTO>> getAllMatches() {
        return ResponseEntity.ok(matchService.getAllMatches());
    }
    
    @PutMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<MatchDTO> updateMatch(@PathVariable Long id, 
                                              @RequestBody MatchDTO matchDTO) {
        return ResponseEntity.ok(matchService.updateMatch(id, matchDTO));
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMatch(@PathVariable Long id) {
        matchService.deleteMatch(id);
        return ResponseEntity.ok().build();
    }
    
    @GetMapping(value = "/competition/{competition}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<MatchDTO>> getMatchesByCompetition(@PathVariable String competition) {
        return ResponseEntity.ok(matchService.findByCompetition(competition));
    }
}
