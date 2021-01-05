package com.example.demo.repository;

import com.example.demo.entity.Company;
import com.example.demo.entity.Internship;
import com.example.demo.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.sql.Timestamp;
import java.util.List;

@Repository
public interface InternshipRepository extends JpaRepository<Internship, Integer> {

  List<Internship> findAll();

  Internship findByInternshipId(Integer internshipId);

  @Transactional
  @Modifying
  @Query("update Internship i set i.internshipBenefits=:internshipBenefits, i.internshipName=:internshipName," +
    "i.internshipAvailableSpaces=:internshipAvailableSpaces, i.internshipStartDate=:internshipStartDate, i.internshipEndDate=:internshipEndDate, i.internshipType=:internshipType where i.internshipId=:id")
  void updateInternShip(@Param("id") Integer id, @Param("internshipStartDate") Timestamp internshipStartDate, @Param("internshipEndDate") Timestamp internshipEndDate, @Param("internshipAvailableSpaces") int internshipAvailableSpaces, @Param("internshipBenefits") String internshipBenefits, @Param("internshipName") String internshipName,
  @Param("internshipType") String internshipType);


}
