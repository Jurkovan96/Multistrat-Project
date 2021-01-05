package com.example.demo.restcontroller;

import com.example.demo.entity.Student;
import com.example.demo.model.StudentUpdateForm;
import com.example.demo.service.StudentService;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.logging.Level;
import java.util.logging.Logger;

@RestController
@RequestMapping("students")
public class StudentRestController {

    Logger logger = Logger.getLogger(StudentRestController.class.getName());

    @Autowired
    StudentService studentService;

    final ModelMapper modelMapper = new ModelMapper();

    @GetMapping("/{id}")
    public Student getTheStudents(@PathVariable Integer id) {
        return studentService.getStudentByIdObject(id);
    }

    @GetMapping("/profile/{id}")
    public StudentUpdateForm studentUpdate(Model model, @PathVariable Integer id) {
        Student student = studentService.getStudentByIdObject(id);
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        StudentUpdateForm studentUpdateForm = modelMapper.map(student, StudentUpdateForm.class);
        if (student.getAddress() != null) {
            studentUpdateForm.setAddressId(student.getAddress().getAddressId());
        } else {
            logger.log(Level.WARNING, "No address found!");
        }
        model.addAttribute("studentUpdateForm", studentUpdateForm);
        model.addAttribute("username", student.getName() + "." + student.getSurname());

        return studentUpdateForm;
    }

    @PostMapping("/profile/{id}")
    public void updateProfile(@PathVariable Integer id, @ModelAttribute("studentUpdateForm") @Valid StudentUpdateForm studentUpdateForm, BindingResult result) {
        Student student = studentService.getStudentByIdObject(id);
        studentService.updateStudent(id, studentUpdateForm);
    }

    @GetMapping("/profile/{id}/delete")
    public HttpEntity<?> deleteStudent(@PathVariable Integer id) {
        studentService.deleteStudent(id);
        if (studentService.getStudentByIdObject(id) == null) {
            logger.log(Level.WARNING, "Student deleted!");
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(id, HttpStatus.OK);
    }

    @PostMapping("/add")
    public void addNewStudent(@ModelAttribute Student student) {
        studentService.addStudent(student);
    }
}