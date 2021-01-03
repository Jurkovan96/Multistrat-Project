package com.example.demo.controller;

import com.example.demo.entity.Student;
import com.example.demo.service.StudentService;
import com.example.demo.service.TaskService;
import com.example.demo.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

import static com.example.demo.util.Constants.UserId;

@Controller
@RequestMapping("team")
@SessionAttributes("id")
public class TeamController {

  @Autowired
  TaskService taskService;

  @Autowired
  TeamService teamService;

  @Autowired
  StudentService studentService;

  @GetMapping
  public String displayTasks(HttpSession httpSession, Model model) {
    String studentId = httpSession.getAttribute("id").toString();
    UserId = httpSession.getAttribute("id").toString();
    model.addAttribute("id", UserId);
    model.addAttribute("StudentList", teamService.getStudentByTeamWithTask(Integer.parseInt(studentId)));
    return "team";
  }

}
