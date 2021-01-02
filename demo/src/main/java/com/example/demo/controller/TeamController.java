package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("team")
@SessionAttributes("id")
public class TeamController {

    @GetMapping
    public String displayTasks(HttpSession httpSession, Model model) {
        String studentId = (String) httpSession.getAttribute("id");
        model.addAttribute("id", studentId);
        return "team";
    }
}
