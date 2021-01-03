package com.example.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

@Entity(name = "Project")
@Table(name = "project")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Project {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Integer projectId;

  @Column(name = "project_name")
  private String projectName;

  @Column(name = "start_date")
  @Temporal(TemporalType.TIMESTAMP)
  private Date projectStartDate;

  @Column(name = "estimated_time")
  @Temporal(TemporalType.TIMESTAMP)
  private Date projectEstimatedTime;

  @OneToOne(fetch = FetchType.LAZY)
  private Team projectTeam;

  @OneToMany(fetch = FetchType.EAGER)
  private List<Task> ProjectTasks;

  public List<Task> getProjectTasks() {
    return ProjectTasks;
  }

  public void setProjectTasks(List<Task> projectTasks) {
    ProjectTasks = projectTasks;
  }

  public Integer getProjectId() {
    return projectId;
  }

  public void setProjectId(Integer projectId) {
    this.projectId = projectId;
  }

  public String getProjectName() {
    return projectName;
  }

  public void setProjectName(String projectName) {
    this.projectName = projectName;
  }

  public Date getProjectStartDate() {
    return projectStartDate;
  }

  public void setProjectStartDate(Date projectStartDate) {
    this.projectStartDate = projectStartDate;
  }

  public void setProjectStartDate(Timestamp projectStartDate) {
    this.projectStartDate = projectStartDate;
  }

  public Date getProjectEstimatedTime() {
    return projectEstimatedTime;
  }

  public void setProjectEstimatedTime(Date projectEstimatedTime) {
    this.projectEstimatedTime = projectEstimatedTime;
  }

  public Team getProjectTeam() {
    return projectTeam;
  }

  public void setProjectTeam(Team projectTeam) {
    this.projectTeam = projectTeam;
  }
}
