package com.example.demo.controller;

import com.example.demo.entity.Student;
import com.example.demo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

@RestController
public class TestRest {

  @Autowired
  StudentService studentService;

  @GetMapping("/show/{name}")
  @ResponseBody
  public Student showUser(@PathVariable String name, HttpSession httpSession) {
    return studentService.getByName(name);
  }


  @GetMapping("/testPage")
  public String doTest() {
    return "hello";
  }
}
