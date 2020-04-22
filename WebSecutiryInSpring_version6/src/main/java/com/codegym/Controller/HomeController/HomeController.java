package com.codegym.Controller.HomeController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomeController {

    @GetMapping(value = "/")
    public String index() {
//        return "LogInForm/LoginForm";
        return "HomePage";
    }

    @RequestMapping(value = "/HomePage")
    public String user() {
        return "HomePage";
    }

    @GetMapping(value = "/login")
    public String loginForm() {
        return "LoginForm/LoginForm";
    }

    @GetMapping(value = "/Access_Denied")
    public String accessDenied() {
        return "Access_Denied";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login() {
        return "user/home";
    }
}
