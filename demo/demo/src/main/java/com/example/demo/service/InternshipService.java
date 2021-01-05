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

  public Internship getInternshipById(Integer id) {
    return internshipRepository.findByInternshipId(id);
  }

  public void deleteInternship(Internship internship) {
    internshipRepository.delete(internship);
  }

  public void updateInternShip(Integer id, Internship internship) {
    internshipRepository.updateInternShip(id, internship.getInternshipStartDate(), internship.getInternshipEndDate(),
      internship.getInternshipAvailableSpaces(), internship.getInternshipBenefits(), internship.getInternshipName(),
      internship.getInternshipType());
  }
}
