package com.codegym.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AdminController {

    @RequestMapping(value = "/admin/welcome")
    public String welcome(){
        return "admin/HomePage";
    }
//    @RequestMapping(value = "/logout")
//    public String logout(){
//        return "/LoginForm/LoginForm";
//    }
}
