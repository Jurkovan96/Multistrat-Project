package com.example.demo.controller;

import com.example.demo.entity.Task;
import com.example.demo.service.ProjectService;
import com.example.demo.service.StudentService;
import com.example.demo.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

import static com.example.demo.util.Constants.UserId;

@Controller
@RequestMapping("task")
public class TaskController {

  @Autowired
  TaskService taskService;

  @Autowired
  StudentService studentService;

  @Autowired
  ProjectService projectService;

  @GetMapping
  public String displayProject(HttpSession httpSession, Model model) {
    String studentId = httpSession.getAttribute("id").toString();
    UserId = httpSession.getAttribute("id").toString();
    model.addAttribute("id", UserId);
    model.addAttribute("taskList", taskService.getAllTasks());
    model.addAttribute("studentList", studentService.getAllStudents());
    model.addAttribute("projectList", projectService.getAllProjects());
    return "task";
  }

  @GetMapping("/{id}/delete")
  public String deleteTask(@PathVariable Integer id) {
    taskService.deleteTaskById(id);
    return "redirect:/task";
  }

  @GetMapping("/{id}/update")
  public String getProjectForDetails(@PathVariable Integer id, Model model) {
    model.addAttribute("singleTask", taskService.getTaskById(id));
    model.addAttribute("listOfStudent", studentService.getAllStudents());
    model.addAttribute("listOfProjects", projectService.getAllProjects());
    return "taskDetails";
  }

  @PostMapping("/{id}/update")
  public String updateProject(@PathVariable Integer id, @RequestParam String taskName, @RequestParam String taskDifficulty, @RequestParam String userId, @RequestParam String project) {
    Task task = new Task();
    task.setTaskName(taskName);
    task.setTaskDifficulty(taskDifficulty);
    task.setUserId(Integer.parseInt(userId));
    task.setProject(projectService.getProjectByName(project));
    taskService.updateTask(id, task);
    return "redirect:/task";
  }

  @PostMapping("/add")
  public String addNewTask(@RequestParam String taskName, @RequestParam String taskDifficulty, @RequestParam String userId, @RequestParam String project) {
    Task task = new Task();
    task.setTaskId(20);
    task.setTaskName(taskName);
    task.setTaskDifficulty(taskDifficulty);
    task.setUserId(Integer.parseInt(userId));
    task.setProject(projectService.getProjectByName(project));
    taskService.addNewTask(task);
    return "redirect:/task";
  }

}
