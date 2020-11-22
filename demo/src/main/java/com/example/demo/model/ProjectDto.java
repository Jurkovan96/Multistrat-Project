package com.example.demo.model;

import com.example.demo.entity.Team;
import lombok.Data;

import java.util.Date;

@Data
public class ProjectDto {

    private int projectId;
    private String projectName;
    private Date projectStartDate;
    private Date projectEstimatedTime;
    private Team projectTeam;

    public int getProjectId() {
        return projectId;
    }

    public void setProjectId(int projectId) {
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
