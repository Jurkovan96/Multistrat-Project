package com.example.demo.repository;

import com.example.demo.entity.Project;
import com.example.demo.entity.Team;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProjectRepository extends JpaRepository<Project, Integer> {

  Project findByProjectId(Integer id);

  Project findByProjectTeam(Team projectTeam);

  List<Project> findAll();


}
