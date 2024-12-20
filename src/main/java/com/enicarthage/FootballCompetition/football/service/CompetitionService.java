package com.enicarthage.FootballCompetition.football.service;

import com.enicarthage.FootballCompetition.football.dto.CompetitionDTO;
import com.enicarthage.FootballCompetition.football.entity.Competition;
import com.enicarthage.FootballCompetition.football.repository.CompetitionRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CompetitionService {
    
    @Autowired
    private CompetitionRepository competitionRepository;
    
    public CompetitionDTO createCompetition(CompetitionDTO competitionDTO) {
        Competition competition = new Competition();
        BeanUtils.copyProperties(competitionDTO, competition);
        competition = competitionRepository.save(competition);
        BeanUtils.copyProperties(competition, competitionDTO);
        return competitionDTO;
    }
    
    public CompetitionDTO getCompetition(Long id) {
        Competition competition = competitionRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Competition not found"));
        CompetitionDTO competitionDTO = new CompetitionDTO();
        BeanUtils.copyProperties(competition, competitionDTO);
        return competitionDTO;
    }
    
    public List<CompetitionDTO> getAllCompetitions() {
        return competitionRepository.findAll().stream()
                .map(competition -> {
                    CompetitionDTO dto = new CompetitionDTO();
                    BeanUtils.copyProperties(competition, dto);
                    return dto;
                })
                .collect(Collectors.toList());
    }
    
    public CompetitionDTO updateCompetition(Long id, CompetitionDTO competitionDTO) {
        Competition competition = competitionRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Competition not found"));
        BeanUtils.copyProperties(competitionDTO, competition, "id");
        competition = competitionRepository.save(competition);
        BeanUtils.copyProperties(competition, competitionDTO);
        return competitionDTO;
    }
    
    public void deleteCompetition(Long id) {
        competitionRepository.deleteById(id);
    }
    
    public List<CompetitionDTO> findByCountry(String country) {
        return competitionRepository.findByCountry(country).stream()
                .map(competition -> {
                    CompetitionDTO dto = new CompetitionDTO();
                    BeanUtils.copyProperties(competition, dto);
                    return dto;
                })
                .collect(Collectors.toList());
    }
}
