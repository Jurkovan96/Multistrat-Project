package tradeIt.com.tarde.it.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;
import tradeIt.com.tarde.it.service.UserService;
import tradeIt.com.tarde.it.utils.Constants;

@Controller
@SessionAttributes(Constants.USER_ID)
@RequestMapping("/")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("index")
    public String getIndex() {
        return "index1";
    }


    @GetMapping("userPage/{emailAddress}")
    public ModelAndView displayUserDetails(@PathVariable String emailAddress) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("userview");
        System.out.println("Name of the user is: " + userService.getUserByEmail(emailAddress).getUser_name());
        modelAndView.addObject("userModel", userService.getUserByEmail(emailAddress));
        return modelAndView;
    }


}
