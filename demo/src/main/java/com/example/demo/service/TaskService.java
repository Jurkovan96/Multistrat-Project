package com.example.demo.service;

import com.example.demo.entity.Task;
import com.example.demo.repository.TaskRepository;
import com.example.demo.util.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {

  @Autowired
  TaskRepository taskRepository;

  public List<Task> getAllUsersTasks(Integer id) {
    return taskRepository.findByUserId(id);
  }

  public String getUnfinishedTask(Integer id) {
    for (Task task : taskRepository.findByUserId(id)) {
      if (task.getTaskStatus().equals(Constants.NOT_FINISHED)) {
        return task.getTaskName();
      }
    }
    return Constants.NO_IN_PROGRESS_TASK;
  }

  public List<Task> getAllTasks() {
    return taskRepository.findAll();
  }
}
