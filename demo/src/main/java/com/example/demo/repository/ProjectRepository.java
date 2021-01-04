package com.example.demo.repository;

import com.example.demo.entity.Project;
import com.example.demo.entity.Team;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;

@Repository
public interface ProjectRepository extends JpaRepository<Project, Integer> {

  Project findByProjectId(Integer id);

  Project findByProjectName(String projectName);

  Project findByProjectTeam(Team projectTeam);

  List<Project> findAll();

  @Transactional
  @Modifying
  @Query("update Project p set p.projectName=:projectName, p.projectEstimatedTime=:projectEstimatedTime, " +
    "p.projectTeam=:projectTeam where p.projectId=:id")
  void updateProject(@Param("id") Integer id, @Param("projectName") String projectName,
                     @Param("projectEstimatedTime") int projectEstimatedTime, @Param("projectTeam") Team projectTeam);
}
