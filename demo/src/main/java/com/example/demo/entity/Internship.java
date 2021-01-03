package com.example.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;

@Entity(name = "Internship")
@Table(name = "internship")
@NoArgsConstructor
@AllArgsConstructor

public class Internship {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Integer internshipId;

  @Column(name = "internshipName")
  private String internshipName;

  @Column(name = "startdate")
  private Timestamp internshipStartDate;

  @Column(name = "enddate")
  private Timestamp internshipEndDate;

  @Column(name = "type")
  private String internshipType;

  @Column(name = "spaces")
  private int internshipAvailableSpaces;

  @Column(name = "benefits")
  private String internshipBenefits;

  @OneToMany(fetch = FetchType.EAGER, mappedBy = "internship")
  private List<Student> listOfStudents;

  @OneToMany(fetch = FetchType.LAZY, mappedBy = "internship")
  private List<Team> listOfTeams;

  @ManyToOne(fetch = FetchType.EAGER)
  @JoinColumn(name = "company_id")
  private Company company;


  public List<Student> getListOfStudents() {
    return listOfStudents;
  }

  public void setListOfStudents(List<Student> listOfStudents) {
    this.listOfStudents = listOfStudents;
  }


  public int getInternshipId() {
    return internshipId;
  }

  public void setInternshipId(int internshipId) {
    this.internshipId = internshipId;
  }

  public String getInternshipName() {
    return internshipName;
  }

  public void setInternshipName(String internshipName) {
    this.internshipName = internshipName;
  }

  public Timestamp getInternshipStartDate() {
    return internshipStartDate;
  }

  public void setInternshipStartDate(Timestamp internshipStartDate) {
    this.internshipStartDate = internshipStartDate;
  }

  public Timestamp getInternshipEndDate() {
    return internshipEndDate;
  }

  public void setInternshipEndDate(Timestamp internshipEndDate) {
    this.internshipEndDate = internshipEndDate;
  }

  public String getInternshipType() {
    return internshipType;
  }

  public void setInternshipType(String internshipType) {
    this.internshipType = internshipType;
  }

  public int getInternshipAvailableSpaces() {
    return internshipAvailableSpaces;
  }

  public void setInternshipAvailableSpaces(int internshipAvailableSpaces) {
    this.internshipAvailableSpaces = internshipAvailableSpaces;
  }

  public Company getCompany() {
    return company;
  }

  public void setCompany(Company company) {
    this.company = company;
  }

  public String getInternshipBenefits() {
    return internshipBenefits;
  }

  public void setInternshipBenefits(String internshipBenefits) {
    this.internshipBenefits = internshipBenefits;
  }
}
