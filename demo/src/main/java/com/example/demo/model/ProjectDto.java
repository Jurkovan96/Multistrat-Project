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
}
