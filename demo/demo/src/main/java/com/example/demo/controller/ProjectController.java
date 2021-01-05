package com.example.demo.controller;

import com.example.demo.entity.Project;
import com.example.demo.service.ProjectService;
import com.example.demo.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.sql.Date;
import java.sql.Timestamp;

import static com.example.demo.util.Constants.UserId;

@Controller
@RequestMapping("project")
@SessionAttributes("id")
public class ProjectController {

  @Autowired
  ProjectService projectService;

  @Autowired
  TeamService teamService;

  @GetMapping
  public String displayProject(HttpSession httpSession, Model model) {
    String studentId = httpSession.getAttribute("id").toString();
    UserId = httpSession.getAttribute("id").toString();
    model.addAttribute("projectList", projectService.getAllProjects());
    model.addAttribute("teamList", teamService.getAllTeams());
    return "project";
  }

  @GetMapping("/{id}/delete")
  public String deleteProject(@PathVariable Integer id) {
    projectService.deleteProjectById(id);
    return "redirect:/project";
  }

  @GetMapping("/{id}/update")
  public String getProjectForDetails(@PathVariable Integer id, Model model) {
    model.addAttribute("singleProject", projectService.getProjectById(id));
    model.addAttribute("listOfTeams", teamService.getAllTeams());
    return "projectDetails";
  }

  @PostMapping("/{id}/update")
  public String updateProject(@PathVariable Integer id, @RequestParam String projectName, @RequestParam int projectEstimatedTime, @RequestParam String projectTeam) {
    Project project = new Project();
    project.setProjectId(id);
    project.setProjectName(projectName);
    project.setProjectEstimatedTime(projectEstimatedTime);
    project.setProjectTeam(teamService.getTeamByName(projectTeam));
    projectService.updateProject(id, project);
    return "redirect:/project";
  }

  @PostMapping("/add")
  public String addNewProject(Model model, @RequestParam String projectName, @RequestParam int projectEstimatedTime, @RequestParam Date projectStartDate, @RequestParam String projectTeam) {
    Project project = new Project();
    project.setProjectId(20);
    project.setProjectName(projectName);
    project.setProjectStartDate(Timestamp.valueOf(String.valueOf(projectStartDate).concat(" 00:00:00")));
    project.setProjectEstimatedTime(projectEstimatedTime);
    try {
      project.setProjectTeam(teamService.getTeamByName(projectTeam));
    } catch (Exception e) {
      model.addAttribute("error", e.getMessage());
      return "redirect:/project";
    }
    System.out.println(project.getProjectId() + project.getProjectName() +
      project.getProjectTeam().getTeamName());
    projectService.addProject(project);
    return "redirect:/project";
  }
}
