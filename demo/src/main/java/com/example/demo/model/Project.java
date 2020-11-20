package com.example.demo.model;

import javax.persistence.*;
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
    private Timestamp projectStartDate;

    @Column(name = "estimated_time")
    private Timestamp projectEstimatedTime;

    @OneToOne(fetch = FetchType.LAZY)
    private Team projectTeam;


}
