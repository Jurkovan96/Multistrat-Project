package com.example.demo.service;

import com.example.demo.entity.Internship;
import com.example.demo.repository.InternshipRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InternshipService {

    @Autowired
    InternshipRepository internshipRepository;

    public List<Internship> getAllInternships() {
        return internshipRepository.findAll();
    }

    public void addNewInternship(Internship internship) {
        internshipRepository.save(internship);
    }

}
