package com.example.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity(name = "Team")
@Table(name = "team")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Team {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Integer teamId;

  @Column(name = "team_name")
  private String teamName;

  @Column(name = "capacity")
  private int teamCapacity;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "internship_id")
  private Internship internship;

  @OneToMany(fetch = FetchType.EAGER, mappedBy = "team")
  private List<Student> listOfStudentsForTeam;

  public List<Student> getListOfStudentsForTeam() {
    return listOfStudentsForTeam;
  }

  public void setListOfStudentsForTeam(List<Student> listOfStudentsForTeam) {
    this.listOfStudentsForTeam = listOfStudentsForTeam;
  }

  public Integer getTeamId() {
    return teamId;
  }

  public void setTeamId(Integer teamId) {
    this.teamId = teamId;
  }

  public String getTeamName() {
    return teamName;
  }

  public void setTeamName(String teamName) {
    this.teamName = teamName;
  }

  public int getTeamCapacity() {
    return teamCapacity;
  }

  public void setTeamCapacity(int teamCapacity) {
    this.teamCapacity = teamCapacity;
  }

  public Internship getInternship() {
    return internship;
  }

  public void setInternship(Internship internship) {
    this.internship = internship;
  }
}
