package com.example.demo.service;

import com.example.demo.entity.Student;
import com.example.demo.entity.Task;
import com.example.demo.entity.Team;
import com.example.demo.model.StudentDto;
import com.example.demo.repository.StudentRepository;
import com.example.demo.repository.TaskRepository;
import com.example.demo.repository.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeamService {

  @Autowired
  StudentService studentService;

  @Autowired
  TeamRepository teamRepository;

  @Autowired
  StudentRepository studentRepository;

  @Autowired
  TaskRepository taskRepository;

  public List<Student> getStudentsByTeamBy(Integer id) {
    Team team = teamRepository.findByTeamId(studentRepository.findByUserId(id).getTeam().getTeamId());
    return team.getListOfStudentsForTeam();
  }

  public Team getTeamByStudentId(Integer id) {
    return teamRepository.findByTeamId(studentRepository.findByUserId(id).getTeam().getTeamId());
  }

  public List<StudentDto> getStudentByTeamWithTask(Integer id) {
    Team team = teamRepository.findByTeamId(studentRepository.findByUserId(id).getTeam().getTeamId());
    return studentService.getAllWithTasks(team.getListOfStudentsForTeam());
  }



}
