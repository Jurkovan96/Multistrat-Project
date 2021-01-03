package com.example.demo.controller;

import com.example.demo.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import javax.servlet.http.HttpSession;

import static com.example.demo.util.Constants.UserId;

@Controller
@RequestMapping("project")
@SessionAttributes("id")
public class ProjectController {

  @Autowired
  ProjectService projectService;

  @GetMapping
  public String displayProject(HttpSession httpSession, Model model) {
    String studentId = httpSession.getAttribute("id").toString();
    UserId = httpSession.getAttribute("id").toString();
    model.addAttribute("projectList", projectService.getAllProjects());
    return "project";
  }

  @GetMapping("/{id}/delete")
  public String deleteProject(@PathVariable Integer id) {
    projectService.deleteProjectById(id);
    return "redirect:/project";
  }

}
