package com.example.demo.controller;

import com.example.demo.model.StudentDto;
import com.example.demo.restcontroller.StudentRestController;
import com.example.demo.service.StudentService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

@Controller
@RequestMapping("students1")
public class StudentController {
    /**
     * Service for getting the needed data.
     */
    @Autowired
    private StudentService studentService;
    /**
     * Mapper for the class object
     */
    final ModelMapper modelMapper = new ModelMapper();
    /**
     * Logger used for log the current class
     */
    Logger logger = Logger.getLogger(StudentRestController.class.getName());

    private final ModelAndView mModeAndView = new ModelAndView();

    private final List<StudentDto> studentListInDto = new ArrayList<>();

    @GetMapping
    public ModelAndView displayStudentPage() {

        mModeAndView.setViewName("studentsPage");
        mModeAndView.addObject("studentsList", studentService.getAllStudents());

        return mModeAndView;
    }
//
//    public void getAllStudents() {
//        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
//        for (Student student : studentService.getAllStudents()) {
//            StudentDto studentDto = modelMapper.map(student, StudentDto.class);
//            studentListInDto.add(studentDto);
//
//        }
//        logger.log(Level.INFO, String.valueOf(studentListInDto.size()));
//    }


}
