package com.example.demo.service;

import com.example.demo.entity.Project;
import com.example.demo.entity.Student;
import com.example.demo.entity.Task;
import com.example.demo.entity.Team;
import com.example.demo.model.TaskDto;
import com.example.demo.repository.TaskRepository;
import com.example.demo.util.Constants;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TaskService {

  @Autowired
  TaskRepository taskRepository;

  @Autowired
  StudentService studentService;

  @Autowired
  TaskService taskService;

  @Autowired
  TeamService teamService;

  @Autowired
  ProjectService projectService;

  final ModelMapper modelMapper = new ModelMapper();

  public List<Task> getAllUsersTasks(Integer id) {
    return taskRepository.findByUserId(id);
  }

  public Task getTaskById(Integer id) {
    return taskRepository.findByTaskId(id);
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

  public List<Task> getAllTasksByTeam(Integer id) {
    List<Task> tasksPerProject = new ArrayList<>();
    Team team = teamService.getTeamByStudentId(id);
    Project project = projectService.getProjectByTeam(team);
    for (Task task : taskService.getAllTasks()) {
      if (task.getProject().getProjectId().equals(project.getProjectId())) {
        tasksPerProject.add(task);
      }
    }
    return tasksPerProject;
  }

  public List<TaskDto> getAllTaskWithUserNames(Integer id) {
    List<TaskDto> taskDtoWithUser = new ArrayList<>();
    for (Task task : this.getAllTasksByTeam(id)) {
      TaskDto taskDto = modelMapper.map(task, TaskDto.class);
      taskDto.setStudentName(studentService.getStudentById(task.getUserId()).getName()
        .concat(" - ")
        .concat(studentService.getStudentById(task.getUserId()).getName()));
      taskDtoWithUser.add(taskDto);
    }
    return taskDtoWithUser;
  }

  public List<String> getAllTasksNames(Integer id) {
    List<String> nameOfTasks = new ArrayList<>();
    for (TaskDto task : this.getAllTaskWithUserNames(id)) {
      nameOfTasks.add(task.getTaskName());
    }
    return nameOfTasks;
  }

  public void updateStatus(Integer taskId, Task task) {
    taskRepository.updateTaskStatus(taskId, task.getTaskStatus());
  }

  public void updateReview(Integer taskId, String taskReview) {
    taskRepository.updateTaskReview(taskId, taskReview);
  }
}
