package tradeIt.com.tarde.it.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import tradeIt.com.tarde.it.service.UserService;
import tradeIt.com.tarde.it.utils.Constants;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/")
@SessionAttributes
public class LoginController {

    @Autowired
    private UserService userService;

    @GetMapping("login")
    public String displayLoginPage() {
        return "login";
    }

    @PostMapping
    public String loginUser(HttpSession httpSession, @RequestParam String userEmail, @RequestParam String password) {
        ModelAndView modelAndView = new ModelAndView();
        if (!userService.performLogin(userEmail, password)) {
            modelAndView.addObject(Constants.ERROR, Constants.LOGIN_ERROR);
        } else {
            httpSession.setAttribute(Constants.USER_ID, userService.getUserByEmail(userEmail).getId());
            modelAndView.addObject(Constants.USER_OBJECT, userService.getUserByEmail(userEmail));
        }
        return "redirect: /index";
    }
}
