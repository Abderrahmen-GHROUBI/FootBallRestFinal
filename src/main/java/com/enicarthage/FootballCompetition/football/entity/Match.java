package com.enicarthage.FootballCompetition.football.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "matches")
public class Match {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String competition;
    private Integer year;
    private String round;
    private String team1;
    private String team2;
    private Integer team1goals;
    private Integer team2goals;

    public Match() {
    }

    public Match(Long id, String competition, Integer year, String round, String team1, String team2, Integer team1goals, Integer team2goals) {
        this.id = id;
        this.competition = competition;
        this.year = year;
        this.round = round;
        this.team1 = team1;
        this.team2 = team2;
        this.team1goals = team1goals;
        this.team2goals = team2goals;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCompetition() {
        return competition;
    }

    public void setCompetition(String competition) {
        this.competition = competition;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public String getRound() {
        return round;
    }

    public void setRound(String round) {
        this.round = round;
    }

    public String getTeam1() {
        return team1;
    }

    public void setTeam1(String team1) {
        this.team1 = team1;
    }

    public String getTeam2() {
        return team2;
    }

    public void setTeam2(String team2) {
        this.team2 = team2;
    }

    public Integer getTeam1goals() {
        return team1goals;
    }

    public void setTeam1goals(Integer team1goals) {
        this.team1goals = team1goals;
    }

    public Integer getTeam2goals() {
        return team2goals;
    }

    public void setTeam2goals(Integer team2goals) {
        this.team2goals = team2goals;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Match match = (Match) o;
        return id != null && id.equals(match.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }

    @Override
    public String toString() {
        return "Match{" +
                "id=" + id +
                ", competition='" + competition + '\'' +
                ", year=" + year +
                ", round='" + round + '\'' +
                ", team1='" + team1 + '\'' +
                ", team2='" + team2 + '\'' +
                ", team1goals=" + team1goals +
                ", team2goals=" + team2goals +
                '}';
    }
}
