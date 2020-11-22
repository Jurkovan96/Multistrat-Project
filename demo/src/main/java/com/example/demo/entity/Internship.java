package com.example.demo.entity;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;

@Entity(name = "Internship")
@Table(name = "internship")
public class Internship {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int internshipId;

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

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "internship")
    private List<Student> listOfStudents;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "internship")
    private List<Team> listOfTeams;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "company_id")
    private Company company;


    public List<Student> getListOfStudents() {
        return listOfStudents;
    }

    public void setListOfStudents(List<Student> listOfStudents) {
        this.listOfStudents = listOfStudents;
    }

    public Internship() {
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

    public String getInternshipBenefits() {
        return internshipBenefits;
    }

    public void setInternshipBenefits(String internshipBenefits) {
        this.internshipBenefits = internshipBenefits;
    }
}
