package com.example.demo.service;

import com.example.demo.entity.Company;
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
}
