package com.example.demo.restcontroller;

import com.example.demo.entity.Student;
import com.example.demo.model.StudentUpdateForm;
import com.example.demo.service.StudentService;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("students")
public class StudentController {

    @Autowired
    StudentService studentService;

    final ModelMapper modelMapper = new ModelMapper();


    @GetMapping("/profile/{id}")
    public StudentUpdateForm customerProfile(Model model, @PathVariable Integer id) {
        Student student = studentService.getStudentByIdObject(id);
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        StudentUpdateForm studentUpdateForm = modelMapper.map(student, StudentUpdateForm.class);
        model.addAttribute("studentUpdateForm", studentUpdateForm);
        model.addAttribute("username", student.getName() + "." + student.getSurname());

        return studentUpdateForm;
    }

    @PostMapping("/profile/{id}")
    public void updateProfile(@PathVariable Integer id, @ModelAttribute("studentUpdateForm") @Valid StudentUpdateForm studentUpdateForm, BindingResult result) {
        Student student = studentService.getStudentByIdObject(id);
        studentService.updateStudent(id, studentUpdateForm);
        System.out.println(student.getName());
    }
}