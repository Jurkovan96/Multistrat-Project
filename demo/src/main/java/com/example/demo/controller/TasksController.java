package com.example.demo.controller;

import com.example.demo.entity.Task;
import com.example.demo.service.TaskService;
import com.example.demo.service.TeamService;
import com.example.demo.util.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

import static com.example.demo.util.Constants.UserId;

@Controller
@RequestMapping("tasks")
@SessionAttributes("id")
public class TasksController {

  @Autowired
  TaskService taskService;

  @Autowired
  TeamService teamService;

  @GetMapping
  public String displayTasks(HttpSession httpSession, Model model) {
    String studentId = httpSession.getAttribute("id").toString();
    UserId = httpSession.getAttribute("id").toString();
    model.addAttribute("id", UserId);
    model.addAttribute("taskList", taskService.getAllTaskWithUserNames(Integer.parseInt(UserId)));
    return "tasks";
  }

  @GetMapping("/{taskId}")
  public String editTaskStatus(@PathVariable Integer taskId, Model model) {
    Task task = taskService.getTaskById(taskId);
    task.setTaskStatus(Constants.FINISHED);
    //model.addAttribute("task", task);
    taskService.updateStatus(task.getTaskId(), task);
    return "redirect:/tasks";
  }

  @GetMapping("/{taskId}/{taskName}")
  public String editTaskReview(@PathVariable Integer taskId, @PathVariable String taskName) {
    Task task = taskService.getTaskById(taskId);
    //model.addAttribute("task2", task);
    task.setTaskReview("Review Added");
    System.out.println(taskName);
    taskService.updateReview(task.getTaskId(), "task");
    return "redirect:/tasks";
  }

  @PostMapping("/{taskId}")
  public String editTaskReviewPost(@PathVariable Integer taskId, @RequestParam String taskReview) {
    taskService.updateReview(taskId, taskReview);
    return "redirect:/tasks";
  }
}
