package com.codegym.Controller.AdminController;

import com.codegym.Authentication.Authentication;
import com.codegym.Entity.Book;
import com.codegym.Entity.User;

import com.codegym.Service.UserService.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.security.Principal;
import java.util.List;

@Controller
@RequestMapping(value = "/admin")
public class AdminController {

    @Autowired
    Authentication authentication;

    @Autowired
    IUserService userService;

    @RequestMapping(value = "/welcome")
    public String welcome(){
        return "admin/HomePage";
    }
    @GetMapping(value = "/profile")
    public ModelAndView getAdminProfile(Principal principal){
        ModelAndView modelAndView = new ModelAndView("admin/profile");
        UserDetails userDetail = authentication.loadUserByUsername(principal.getName());
        User user = userService.findOneByUsernameAndStatus(principal.getName(),1);
        modelAndView.addObject("admin",userDetail);
        modelAndView.addObject("user",user);
        return modelAndView;
    }

    @RequestMapping(value = "change/infor", method = RequestMethod.GET)
    public ModelAndView showInformationChangePage(Principal principal){
        ModelAndView modelAndView = new ModelAndView("admin/ProfileChange");
        User user = userService.findOneByUsernameAndStatus(principal.getName(),1);
        modelAndView.addObject("user",user);
        return modelAndView;
    }

    @RequestMapping(value = "change/infor", method = RequestMethod.POST)
    public ModelAndView chaneInformation(@ModelAttribute User user, Principal principal){
        ModelAndView modelAndView = new ModelAndView("admin/ProfileChange");
        User currentUser = userService.findOneByUsernameAndStatus(principal.getName(), 1);
        user.setRoleList(currentUser.getRoleList());
        user.setStatus(1);
        userService.save(user);
        modelAndView.addObject("user",user);
        modelAndView.addObject("message","Updated successfully");
        return modelAndView;
    }
    @RequestMapping(value = "signUp",method = RequestMethod.GET)
    public String signUp(){
        return null;
    }



//    @RequestMapping(value = "/logout")
//    public String logout(){
//        return "/LoginForm/LoginForm";
//    }
}
