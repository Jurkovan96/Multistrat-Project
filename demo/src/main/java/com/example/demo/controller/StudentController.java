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

//@Controller
//@RequestMapping("profile")
//public class StudentController {
//
//  @GetMapping
//  public String showProfile(){
//    return "profile";
//  }
//
//}
