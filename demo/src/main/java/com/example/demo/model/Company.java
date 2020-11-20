package com.example.demo.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "Company")
@Table(name = "company")
public class Company extends User {

    @Column(name = "companyName")
    private String companyName;

    @Column(name = "companyCode")
    private String companyCode;

    @Column(name = "contactPerson")
    private String contactPerson;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "company")
    private final List<Department> departments = new ArrayList<>();

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "company")
    private final List<Internship> internships = new ArrayList<>();

    public List<Department> getDepartments() {
        return departments;
    }

    public Company() {
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getCompanyCode() {
        return companyCode;
    }

    public void setCompanyCode(String companyCode) {
        this.companyCode = companyCode;
    }

    public String getContactPerson() {
        return contactPerson;
    }

    public void setContactPerson(String contactPerson) {
        this.contactPerson = contactPerson;
    }
}
