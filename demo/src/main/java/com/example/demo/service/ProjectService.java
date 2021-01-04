package com.example.demo.service;

import com.example.demo.entity.Project;
import com.example.demo.entity.Team;
import com.example.demo.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectService {

  @Autowired
  ProjectRepository projectRepository;

  @Autowired
  CompanyService companyService;

  public Project getProjectById(Integer id) {
    return projectRepository.findByProjectId(id);
  }

  public Project getProjectByTeam(Team team) {
    return projectRepository.findByProjectTeam(team);
  }

  public List<Project> getAllProjects() {
    return projectRepository.findAll();
  }

  public void deleteProjectById(Integer id) {
    Project project = projectRepository.findByProjectId(id);
    projectRepository.delete(project);
  }

  public void updateProject(Integer id, Project project) {
    projectRepository.updateProject(id, project.getProjectName(), project.getProjectEstimatedTime(), project.getProjectTeam());
  }

  public void addProject(Project project) {
    projectRepository.save(project);
  }

  public Project getProjectByName(String project) {
    return projectRepository.findByProjectName(project);
  }
}
