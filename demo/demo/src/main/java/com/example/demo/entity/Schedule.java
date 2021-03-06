package com.example.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity(name = "Schedule")
@Table(name = "schedule")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Schedule {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer scheduleId;

    @Column(name = "start_time")
    private Timestamp scheduleStart;

    @Column(name = "end_time")
    private Timestamp scheduleEnd;

    @Column(name = "estimated_time")
    private Timestamp scheduleEstimatedTime;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "task_id")
    private Task task;

    public Integer getScheduleId() {
        return scheduleId;
    }

    public void setScheduleId(Integer scheduleId) {
        this.scheduleId = scheduleId;
    }

    public Timestamp getScheduleStart() {
        return scheduleStart;
    }

    public void setScheduleStart(Timestamp scheduleStart) {
        this.scheduleStart = scheduleStart;
    }

    public Timestamp getScheduleEnd() {
        return scheduleEnd;
    }

    public void setScheduleEnd(Timestamp scheduleEnd) {
        this.scheduleEnd = scheduleEnd;
    }

    public Timestamp getScheduleEstimatedTime() {
        return scheduleEstimatedTime;
    }

    public void setScheduleEstimatedTime(Timestamp scheduleEstimatedTime) {
        this.scheduleEstimatedTime = scheduleEstimatedTime;
    }

    public Task getTask() {
        return task;
    }

    public void setTask(Task task) {
        this.task = task;
    }
}
