package com.example.demo.model;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Timestamp;

@Entity(name = "Project")
@Table(name = "project")
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

    public Integer getProjectId() {
        return projectId;
    }

    public void setProjectId(Integer projectId) {
        this.projectId = projectId;
    }
}
