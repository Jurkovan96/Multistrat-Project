package com.example.demo.service;

import com.example.demo.entity.Company;
import com.example.demo.repository.CompanyRepository;
import com.example.demo.util.ValidationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class CompanyService {

    @Autowired
    CompanyRepository companyRepository;

    public List<Company> getAllCompanies() {
        return companyRepository.findAll();
    }


    public boolean checkCompanyLogin(String emailAddress, String password) {
        if (companyRepository.findByEmail(emailAddress) != null) {
            if (companyRepository.findByEmail(emailAddress).getPassword().equals(password)) {
                return true;
            } else {
                throw new ValidationException("wrong.password");
            }
        } else {
            throw new ValidationException("wrong.emailAddress");
        }
    }

    public Company getByEmail(String email) {
        return companyRepository.findByEmail(email);
    }

    public Company getCompanyById(Integer companyId) {
        return companyRepository.findByUserId(companyId);
    }

}
