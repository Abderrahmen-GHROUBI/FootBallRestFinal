package com.enicarthage.FootballCompetition.football.dto;

public class CompetitionDTO {
    private Long id;
    private String name;
    private String country;
    private Integer year;
    private String winner;
    private String runnerup;

    public CompetitionDTO() {
    }

    public CompetitionDTO(Long id, String name, String country, Integer year, String winner, String runnerup) {
        this.id = id;
        this.name = name;
        this.country = country;
        this.year = year;
        this.winner = winner;
        this.runnerup = runnerup;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public String getWinner() {
        return winner;
    }

    public void setWinner(String winner) {
        this.winner = winner;
    }

    public String getRunnerup() {
        return runnerup;
    }

    public void setRunnerup(String runnerup) {
        this.runnerup = runnerup;
    }

    @Override
    public String toString() {
        return "CompetitionDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", country='" + country + '\'' +
                ", year=" + year +
                ", winner='" + winner + '\'' +
                ", runnerup='" + runnerup + '\'' +
                '}';
    }
}
