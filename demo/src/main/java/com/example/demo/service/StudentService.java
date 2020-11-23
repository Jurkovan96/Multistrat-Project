package com.example.demo.service;

import com.example.demo.entity.Student;
import com.example.demo.model.StudentDto;
import com.example.demo.model.StudentUpdateForm;
import com.example.demo.repository.AddressRepository;
import com.example.demo.repository.StudentRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    @Autowired
    StudentRepository studentRepository;

    @Autowired
    AddressRepository addressRepository;

    private final ModelMapper modelMapper = new ModelMapper();

    public StudentDto getStudentById(Integer studentId) {
        return modelMapper.map(studentRepository.findByUserId(studentId), StudentDto.class);
    }

    public void updateStudent(Integer studentId, StudentUpdateForm studentUpdateForm) {
        studentRepository.updateStudent(studentId, studentUpdateForm.getEmail(), studentUpdateForm.getPassword(),
                studentUpdateForm.getName(), studentUpdateForm.getSurname(), studentUpdateForm.getFaculty(),
                studentUpdateForm.getPhoneNumber(), studentUpdateForm.getBirthDate());
    }

    public Student getStudentByIdObject(Integer studentId) {
        return studentRepository.findByUserId(studentId);
    }

    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    public void saveStudent(Student student) {
        studentRepository.save(student);
    }

    public void deleteStudent(Integer id) {
        studentRepository.deleteById(id);
    }

    public void addStudent(Student student) {
        studentRepository.save(student);
    }
}
