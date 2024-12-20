package com.enicarthage.FootballCompetition.football.repository;

import com.enicarthage.FootballCompetition.football.entity.Competition;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CompetitionRepository extends JpaRepository<Competition, Long> {
    List<Competition> findByCountry(String country);
    List<Competition> findByYear(Integer year);
    List<Competition> findByWinner(String winner);
}
