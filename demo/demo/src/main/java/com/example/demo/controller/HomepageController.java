package com.example.demo.controller;

import com.example.demo.entity.Internship;
import com.example.demo.service.CompanyService;
import com.example.demo.service.InternshipService;
import com.example.demo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.sql.Date;
import java.sql.Timestamp;

@Controller
@SessionAttributes("id")
public class HomepageController {

  @Autowired
  private StudentService studentService;

  @Autowired
  private InternshipService internshipService;

  @Autowired
  private CompanyService companyService;


  @RequestMapping(value = "/homepageCompany", method = RequestMethod.GET)
  public String displayHomePageForCompany(HttpSession session, Model model) {
    String s = session.getAttribute("id").toString();
    model.addAttribute("loggedUser", companyService.getCompanyById(Integer.parseInt(s)));
    model.addAttribute("listOfInternships", internshipService.getAllInternships());
    return "homeCompany";
  }

  @RequestMapping(value = "/homepageStudent", method = RequestMethod.GET)
  public String displayHomePageForStudent(HttpSession session, Model model) {
    String s = session.getAttribute("id").toString();
    model.addAttribute("loggedUser", studentService.getStudentByIdObject(Integer.parseInt(s)));
    model.addAttribute("listOfInternships", internshipService.getAllInternships());
    model.addAttribute("companyName", studentService.getCompanyName(studentService.getStudentByIdObject(Integer.parseInt(s))));
    return "homeStudent";
  }

  @RequestMapping(value = "/homepageCompany", method = RequestMethod.POST)
  public String addInternship(HttpSession httpSession, @RequestParam String internshipName, @RequestParam Date internshipStartDate, @RequestParam Date internshipEndDate, @RequestParam String internshipDesc) {
    Internship internship = new Internship();
    String s = httpSession.getAttribute("id").toString();
    internship.setCompany(companyService.getCompanyById(Integer.parseInt(s)));
    internship.setInternshipAvailableSpaces(20);
    internship.setInternshipBenefits(internshipDesc);
    internship.setInternshipName(internshipName);
    internship.setInternshipEndDate(Timestamp.valueOf(String.valueOf(internshipEndDate).concat(" 00:00:00")));
    internship.setInternshipStartDate(Timestamp.valueOf(String.valueOf(internshipStartDate).concat(" 00:00:00")));
    internship.setInternshipType("Full-time");
    internship.setInternshipId(20);
    internshipService.addNewInternship(internship);
    return "redirect:/homepageCompany";
  }

  @GetMapping("/homepageCompany/{id}/delete")
  public String deleteInternship(@PathVariable Integer id) {
    Internship internship = internshipService.getInternshipById(id);
    internshipService.deleteInternship(internship);
    return "redirect:/homepageCompany";
  }

  @GetMapping("/internship/{id}/update")
  public String getInternshipById(@PathVariable Integer id, Model model) {
    Internship internship = internshipService.getInternshipById(id);
    model.addAttribute("internship", internship);
    return "internshipEdit";
  }

  @PostMapping("/internship/{id}/update")
  public String updateInternship(@PathVariable Integer id, @RequestParam String internshipName, @RequestParam String internshipType, @RequestParam String internshipBenefits, @RequestParam int internshipAvailableSpaces,
                                 @RequestParam String internshipEndDate, @RequestParam String internshipStartDate) {
    Internship getInternShip = internshipService.getInternshipById(id);
    Internship internship = new Internship();
    internship.setInternshipName(internshipName);
    internship.setInternshipId(id);
    internship.setInternshipEndDate(Timestamp.valueOf(internshipEndDate.concat(" 00:00:00")));
    internship.setInternshipStartDate(Timestamp.valueOf(internshipStartDate.concat(" 00:00:00")));
    internship.setInternshipBenefits(internshipBenefits);
    internship.setInternshipAvailableSpaces(internshipAvailableSpaces);
    internship.setInternshipType(internshipType);
    internship.setCompany(getInternShip.getCompany());
    internship.setListOfStudents(getInternShip.getListOfStudents());
    internshipService.updateInternShip(id, internship);
    return "redirect:/homepageCompany";
  }

  @GetMapping("/homepageStudent/tasks")
  public String displayTasksForStudent() {
    return "redirect:/tasks";
  }

  @GetMapping("/homepageStudent/team")
  public String displayTeamForStudent() {
    return "redirect:/team";
  }

  @GetMapping("/homepageStudent/profile")
  public String displayProfileInfo() {
    return "redirect:/profile";
  }

  @GetMapping("/homepageCompany/projects")
  public String displayProjectsForCompany() {
    return "redirect:/project";
  }

  @GetMapping("/homepageCompany/task")
  public String displayTasksForCompany() {
    return "redirect:/task";
  }

}
