package com.example.demo.model;


import com.example.demo.entity.Department;
import com.example.demo.entity.Internship;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class CompanyDto {
    private int companyId;
    private String companyName;
    private String companyCode;
    private String contactPerson;
    private final List<Department> departments = new ArrayList<>();
    private final List<Internship> internships = new ArrayList<>();

    public int getCompanyId() {
        return companyId;
    }

    public void setCompanyId(int companyId) {
        this.companyId = companyId;
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

    public List<Department> getDepartments() {
        return departments;
    }

    public List<Internship> getInternships() {
        return internships;
    }
}
