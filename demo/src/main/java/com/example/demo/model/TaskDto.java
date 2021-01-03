package com.example.demo.model;

import com.example.demo.entity.Project;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TaskDto {

  private Integer taskId;
  private String taskName;
  private String taskReview;
  private String taskDifficulty;
  private Project project;
  private Integer userId;
  private String taskStatus;
  private String studentName;

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

  public String getStudentName() {
    return studentName;
  }

  public void setStudentName(String studentName) {
    this.studentName = studentName;
  }
}
