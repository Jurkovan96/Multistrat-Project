package com.example.demo.controller;

import com.example.demo.restcontroller.StudentRestController;
import com.example.demo.service.StudentService;
import com.example.demo.util.ValidationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.Locale;
import java.util.logging.Logger;

@Controller
@RequestMapping("/login")
@SessionAttributes("id")
public class LoginController {

    private final Logger logger = Logger.getLogger(StudentRestController.class.getName());

    @Autowired
    private StudentService studentService;

    @Autowired
    private ApplicationContext applicationContext;

    @GetMapping
    public ModelAndView displayLogin() {
        return new ModelAndView("login");
    }

    @PostMapping
    public ModelAndView doLogin(HttpSession session, @RequestParam String user, @RequestParam String password) {
        ModelAndView mav = new ModelAndView();
        try {
            if (studentService.checkUserObj(user, password)) {
                session.setAttribute("id", studentService.getByEmail(user).getUserId());
                mav.setViewName("redirect:/homepage");
            }
        } catch (ValidationException e) {
            mav.addObject("error", applicationContext.getMessage(e.getCode(), new Object[]{}, Locale.forLanguageTag("ro")));
        }
        return mav;
    }

    @GetMapping("/logout")
    public String doLogout(HttpSession session) {
        session.invalidate();
        return "redirect:/login";
    }

}
