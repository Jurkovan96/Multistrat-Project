package com.example.demo.controller;

import com.example.demo.service.InternshipService;
import com.example.demo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/homepage")
@SessionAttributes("id")
public class HomepageController {

    @Autowired
    private StudentService studentService;

    @Autowired
    private InternshipService internshipService;

    @GetMapping
    public String doMainPage(HttpSession httpSession, Model model) {
//        String s = httpSession.getAttribute("id").toString();
//        model.addAttribute("loggedUser", studentService.getStudentByIdObject(Integer.parseInt(s)));
        model.addAttribute("listOfInternships", internshipService.getAllInternships());
        return "home";
    }


}
