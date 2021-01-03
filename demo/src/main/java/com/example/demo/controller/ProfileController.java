package com.example.demo.controller;

import com.example.demo.model.StudentDto;
import com.example.demo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

import static com.example.demo.util.Constants.UserId;

@Controller
@RequestMapping("profile")
@SessionAttributes("id")
public class ProfileController {

  @Autowired
  StudentService studentService;

  @GetMapping
  public String displayCurrentUserProfile(HttpSession httpSession, Model model) {
    UserId = httpSession.getAttribute("id").toString();
    model.addAttribute("currentUser", httpSession.getAttribute("id").toString());
    model.addAttribute("studentModel", studentService.getStudentForProfilePage(Integer.parseInt(UserId)));
    return "viewProfile";
  }

  @GetMapping("/user/{studentId}")
  public String displayAnotherUsersProfile(@PathVariable Integer studentId, Model model) {
    model.addAttribute("studentModel", studentService.getStudentForProfilePage(studentId));
    return "viewProfile";
  }

  @PostMapping("profile")
  public void editProfilePage(@ModelAttribute(name = "currentUser") StudentDto studentDto) {
    System.out.println(studentDto.getEmail());
  }

}
