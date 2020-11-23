package com.example.demo.service;

import com.example.demo.entity.Student;
import com.example.demo.model.StudentUpdateForm;
import com.example.demo.repository.StudentRepository;
import com.example.demo.restcontroller.StudentDto;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Service
public class StudentService {

    @Autowired
    StudentRepository studentRepository;

    @PersistenceContext
    private EntityManager entityManager;

    private final ModelMapper modelMapper = new ModelMapper();

    public StudentDto getStudentById(Integer studentId) {
        return modelMapper.map(studentRepository.findByUserId(studentId), StudentDto.class);
    }

    public void updateStudent(Integer studentId, StudentUpdateForm studentUpdateForm) {
        studentRepository.updateStudent(studentId, studentUpdateForm.getEmail(), studentUpdateForm.getPassword(),
                studentUpdateForm.getName(), studentUpdateForm.getSurname(), studentUpdateForm.getFaculty(),
                studentUpdateForm.getPhoneNumber(), studentUpdateForm.getBirthDate());
    }

    public Student getStudentByIdObject(Integer studentId){
        return studentRepository.findByUserId(studentId);
    }

    @Transactional
    public void insertWithQuery(Student student) {
        entityManager.createNativeQuery("INSERT INTO Student(passwod, email, phone, address_id, " +
                "name, surname, faculty, birthDate, intership_id) VALUES (?,?,?,?,?,?,?,?,?)")
                .setParameter(1, student.getPassword())
                .setParameter(2, student.getEmail())
                .setParameter(3, student.getPhoneNumber())
                .setParameter(4, student.getAddress().getAddressId())
                .setParameter(5, student.getName())
                .setParameter(6, student.getSurname())
                .setParameter(7, student.getFaculty())
                .setParameter(8, student.getBirthDate())
                .setParameter(9, student.getInternship().getInternshipId())
                .executeUpdate();
    }

    @Transactional
    public void insertWithEntityManager(Student student) {
        this.entityManager.persist(student);
    }

}
