package com.codegym.Controller.UserController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class UserController {

    @GetMapping(value = "/")
    public String index() {
//        return "LogInForm/LoginForm";
        return "HomePage";
    }

    @RequestMapping(value = "/home")
    public String user() {
        return "home";
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
        return "home";
    }



//
//    @GetMapping("/admin")
//    public String admin() {
//        // Get authenticated user name from SecurityContext
//        SecurityContext context = SecurityContextHolder.getContext();
//        System.out.println(context.getAuthentication().getName());
//        return "admin";
//    }
}