package com.enicarthage.FootballCompetition.football.service;

import com.enicarthage.FootballCompetition.football.dto.MatchDTO;
import com.enicarthage.FootballCompetition.football.entity.Match;
import com.enicarthage.FootballCompetition.football.repository.MatchRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MatchService {
    
    @Autowired
    private MatchRepository matchRepository;
    
    public MatchDTO createMatch(MatchDTO matchDTO) {
        Match match = new Match();
        BeanUtils.copyProperties(matchDTO, match);
        match = matchRepository.save(match);
        BeanUtils.copyProperties(match, matchDTO);
        return matchDTO;
    }
    
    public MatchDTO getMatch(Long id) {
        Match match = matchRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Match not found"));
        MatchDTO matchDTO = new MatchDTO();
        BeanUtils.copyProperties(match, matchDTO);
        return matchDTO;
    }
    
    public List<MatchDTO> getAllMatches() {
        return matchRepository.findAll().stream()
                .map(match -> {
                    MatchDTO dto = new MatchDTO();
                    BeanUtils.copyProperties(match, dto);
                    return dto;
                })
                .collect(Collectors.toList());
    }
    
    public MatchDTO updateMatch(Long id, MatchDTO matchDTO) {
        Match match = matchRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Match not found"));
        BeanUtils.copyProperties(matchDTO, match, "id");
        match = matchRepository.save(match);
        BeanUtils.copyProperties(match, matchDTO);
        return matchDTO;
    }
    
    public void deleteMatch(Long id) {
        matchRepository.deleteById(id);
    }
    
    public List<MatchDTO> findByCompetition(String competition) {
        return matchRepository.findByCompetition(competition).stream()
                .map(match -> {
                    MatchDTO dto = new MatchDTO();
                    BeanUtils.copyProperties(match, dto);
                    return dto;
                })
                .collect(Collectors.toList());
    }
}
