package com.example.demo.repository;

import com.example.demo.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {

    List<Student> findAll();

    Student findByUserId(Integer userId);

    Student findByEmail(String email);

    @Modifying
    @Transactional
    @Query("update Student s set s.email=:email, s.password=:password, s.phoneNumber=:phoneNo, s.faculty=:faculty, " +
            "s.birthDate =:dateOfBirth, s.name=:name, s.surname=:surname where s.userId=:id")
    void updateStudent(@Param("id") Integer id, @Param("email") String email, @Param("password") String password,
                       @Param("name") String name, @Param("surname") String surname, @Param("faculty") String faculty,
                       @Param("phoneNo") String phoneNo, @Param("dateOfBirth") Date dateOfBirth);

  Student findByName(String name);
}
