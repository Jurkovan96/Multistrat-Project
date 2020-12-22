package com.example.demo.controller;

import com.example.demo.service.CompanyService;
import com.example.demo.service.StudentService;
import com.example.demo.util.ValidationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.Locale;

@Controller
@RequestMapping("/login")
@SessionAttributes("id")
public class LoginController {

    @Autowired
    private StudentService studentService;

    @Autowired
    private CompanyService companyService;

    @Autowired
    private ApplicationContext applicationContext;

    private final ModelAndView modelAndView = new ModelAndView();

    @GetMapping
    public ModelAndView displayLogin() {
        modelAndView.setViewName("login");
        return modelAndView;
    }

    @PostMapping
    public ModelAndView doLoginStudent(HttpSession session, @RequestParam String user, @RequestParam String password) {
        try {
            if (studentService.checkUserObj(user, password)) {
                session.setAttribute("id", studentService.getByEmail(user).getUserId());
                modelAndView.setViewName("redirect:/homepageStudent");
                modelAndView.addObject("errorStudent", null);
            }
        } catch (ValidationException e) {
            modelAndView.addObject("errorStudent", applicationContext.getMessage(e.getCode(), new Object[]{}, Locale.forLanguageTag("ro")));
        }
        return modelAndView;
    }

    @RequestMapping(value = "/login", name = "companyPost", method = RequestMethod.POST)
    public ModelAndView doLoginCompany(HttpSession session, @RequestParam String companyEmail, @RequestParam String companyPassword) {
        try {
            if (companyService.checkCompanyLogin(companyEmail, companyPassword)) {
                session.setAttribute("id", companyService.getByEmail(companyEmail).getUserId());
                modelAndView.setViewName("redirect:/homepageCompany");
                modelAndView.addObject("errorCompany", null);
            }
        } catch (ValidationException e) {
            modelAndView.addObject("errorCompany", applicationContext.getMessage(e.getCode(), new Object[]{}, Locale.forLanguageTag("ro")));
        }
        return modelAndView;
    }


}

