package com.enicarthage.FootballCompetition.football.repository;

import com.enicarthage.FootballCompetition.football.entity.Match;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MatchRepository extends JpaRepository<Match, Long> {
    List<Match> findByCompetition(String competition);
    List<Match> findByYear(Integer year);
    List<Match> findByTeam1OrTeam2(String team1, String team2);
}
