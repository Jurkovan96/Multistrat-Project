package com.example.demo.service;

import com.example.demo.entity.Project;
import com.example.demo.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProjectService {

  @Autowired
  ProjectRepository projectRepository;

  public Project getProjectById(Integer id){
    return projectRepository.findByProjectId(id);
  }



}
