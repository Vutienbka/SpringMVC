package com.codegym.Controller;

import com.codegym.Model.Login;
import com.codegym.Model.User;
import com.codegym.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@EnableWebMvc
@Controller
public class UserController {
    @Autowired
    UserService userService;

    @RequestMapping(value = "/loginForm")
    public String gotoLoginForm(Model model){
        Login login = new Login();
        model.addAttribute("login",login);
        return "LogIn";
    }

    @RequestMapping(value = "/login")
    public String checkLogin(@ModelAttribute("login") Login login, Model model){
        User user = userService.checkLogin(login);
        if(user==null)
            return "Error";
        else {
            model.addAttribute("user",user);
        }
        return "User";
    }

}
