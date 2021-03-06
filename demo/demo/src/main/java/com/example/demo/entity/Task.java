package com.example.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity(name = "Task")
@Table(name = "task")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Task {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Integer taskId;

  @Column(name = "task_name")
  private String taskName;

  @Column(name = "review")
  private String taskReview;

  @Column(name = "difficulty")
  private String taskDifficulty;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "project_id")
  private Project project;

  @Column(name = "user_id")
  private Integer userId;

  @Column(name = "task_status")
  private String taskStatus;

  public Integer getUserId() {
    return userId;
  }

  public void setUserId(Integer userId) {
    this.userId = userId;
  }

  public String getTaskStatus() {
    return taskStatus;
  }

  public void setTaskStatus(String taskStatus) {
    this.taskStatus = taskStatus;
  }

  public Integer getTaskId() {
    return taskId;
  }

  public void setTaskId(Integer taskId) {
    this.taskId = taskId;
  }

  public String getTaskName() {
    return taskName;
  }

  public void setTaskName(String taskName) {
    this.taskName = taskName;
  }

  public String getTaskReview() {
    return taskReview;
  }

  public void setTaskReview(String taskReview) {
    this.taskReview = taskReview;
  }

  public String getTaskDifficulty() {
    return taskDifficulty;
  }

  public void setTaskDifficulty(String taskDifficulty) {
    this.taskDifficulty = taskDifficulty;
  }

  public Project getProject() {
    return project;
  }

  public void setProject(Project project) {
    this.project = project;
  }
}
