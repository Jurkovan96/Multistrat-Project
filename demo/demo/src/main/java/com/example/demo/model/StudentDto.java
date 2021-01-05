package com.example.demo.model;

import com.example.demo.entity.Task;
import lombok.Data;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
public class StudentDto {
  private Integer id;
  private String email;
  private String faculty;
  private String name;
  private String surname;
  private Date birthDate;
  private String phoneNumber;
  private String password;
  private String currentTask;
  private List<String> listOfContacts = new ArrayList<>();
  private List<Task> listOfAllTasks = new ArrayList<>();

  public List<Task> getListOfAllTasks() {
    return listOfAllTasks;
  }

  public void setListOfAllTasks(List<Task> listOfAllTasks) {
    this.listOfAllTasks = listOfAllTasks;
  }

  public List<String> getListOfContacts() {
    return listOfContacts;
  }

  public void setListOfContacts(List<String> listOfContacts) {
    this.listOfContacts = listOfContacts;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getCurrentTask() {
    return currentTask;
  }

  public void setCurrentTask(String currentTask) {
    this.currentTask = currentTask;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getFaculty() {
    return faculty;
  }

  public void setFaculty(String faculty) {
    this.faculty = faculty;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getSurname() {
    return surname;
  }

  public void setSurname(String surname) {
    this.surname = surname;
  }

  public Date getBirthDate() {
    return birthDate;
  }

  public void setBirthDate(Date birthDate) {
    this.birthDate = birthDate;
  }

  public String getPhoneNumber() {
    return phoneNumber;
  }

  public void setPhoneNumber(String phoneNumber) {
    this.phoneNumber = phoneNumber;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }
}
