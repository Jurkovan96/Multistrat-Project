package com.example.demo.service;

import com.example.demo.entity.Student;
import com.example.demo.entity.Task;
import com.example.demo.model.StudentDto;
import com.example.demo.model.StudentUpdateForm;
import com.example.demo.repository.AddressRepository;
import com.example.demo.repository.CompanyRepository;
import com.example.demo.repository.StudentRepository;
import com.example.demo.util.Constants;
import com.example.demo.util.ValidationException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentService {

  @Autowired
  StudentRepository studentRepository;

  @Autowired
  AddressRepository addressRepository;

  @Autowired
  CompanyRepository companyRepository;

  @Autowired
  TaskService taskService;

  @Autowired
  TeamService teamService;

  @Autowired
  ProjectService projectService;

  private final ModelMapper modelMapper = new ModelMapper();

  public StudentDto getStudentById(Integer studentId) {
    return modelMapper.map(studentRepository.findByUserId(studentId), StudentDto.class);
  }

  public void updateStudent(Integer studentId, StudentUpdateForm studentUpdateForm) {
    studentRepository.updateStudent(studentId, studentUpdateForm.getEmail(), studentUpdateForm.getPassword(),
      studentUpdateForm.getName(), studentUpdateForm.getSurname(), studentUpdateForm.getFaculty(),
      studentUpdateForm.getPhoneNumber());
  }

  public void updateStudentInDto(Integer studentId, StudentDto studentUpdateForm) {
    studentRepository.updateStudent(studentId, studentUpdateForm.getEmail(), studentUpdateForm.getPassword(),
      studentUpdateForm.getName(), studentUpdateForm.getSurname(), studentUpdateForm.getFaculty(),
      studentUpdateForm.getPhoneNumber());
  }

  public Student getStudentByIdObject(Integer studentId) {
    return studentRepository.findByUserId(studentId);
  }

  public List<Student> getAllStudents() {
    return studentRepository.findAll();
  }

  public void saveStudent(Student student) {
    studentRepository.save(student);
  }

  public Student getByEmail(String email) {
    return studentRepository.findByEmail(email);
  }

  public void deleteStudent(Integer id) {
    studentRepository.deleteById(id);
  }

  public void addStudent(Student student) {
    studentRepository.save(student);
  }

  public boolean checkUserObj(String emailAddress, String password) {
    if (studentRepository.findByEmail(emailAddress) != null) {
      if (studentRepository.findByEmail(emailAddress).getPassword().equals(password)) {
        {
          return true;
        }

      } else {
        throw new ValidationException("wrong.password");
      }
    } else {
      throw new ValidationException("wrong.emailAddress");
    }
  }

  public String getCompanyName(Student studentByIdObject) {
    System.out.println(companyRepository.findByUserId(studentByIdObject.getInternship().getCompany().getUserId()).getCompanyName());
    return companyRepository.findByUserId(studentByIdObject.getInternship().getCompany().getUserId()).getCompanyName();
  }


  public Student getByName(String name) {
    return studentRepository.findByName(name);
  }

  public List<StudentDto> getAllWithTasks(List<Student> students) {
    List<StudentDto> studentDtoList = new ArrayList<>();
    for (Student student : students) {
      StudentDto studentDto = modelMapper.map(studentRepository.findByUserId(student.getUserId()), StudentDto.class);
      for (Task task : taskService.getAllTasks()) {
        if (task.getUserId().equals(studentDto.getId()) && task.getTaskStatus().equals(Constants.NOT_FINISHED)) {
          studentDto.setCurrentTask(task.getTaskName().concat(" - ").concat(task.getTaskStatus()));
        } else if (task.getUserId().equals(studentDto.getId()) && task.getTaskStatus().equals(Constants.FINISHED)) {
          studentDto.setCurrentTask(Constants.NO_IN_PROGRESS_TASK);
        }
      }
      studentDtoList.add(studentDto);
    }
    return studentDtoList;
  }

  public StudentDto getStudentForProfilePage(Integer studentId) {
    StudentDto studentDto = this.getStudentById(studentId);
    studentDto.getListOfContacts().add("FaceBook profile");
    studentDto.getListOfContacts().add("Linkin profile");
    studentDto.getListOfContacts().add("Work experience");
    studentDto.getListOfContacts().add("Instagram profile");

    studentDto.setListOfAllTasks(taskService.getAllUsersTasks(studentId));
    return studentDto;
  }
}
