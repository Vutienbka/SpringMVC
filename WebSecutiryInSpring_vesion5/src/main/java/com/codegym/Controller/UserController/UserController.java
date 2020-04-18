package com.codegym.Controller.UserController;

import com.codegym.Authentication.Authentication;
import com.codegym.Entity.User;
import com.codegym.Service.UserService.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.security.Principal;

@Controller
@RequestMapping(value = "/user")
public class UserController {
    @Autowired
    Authentication authentication;

    @Autowired
    IUserService userService;

    @RequestMapping(value = "/homepage")
    public ModelAndView homepage(){
        ModelAndView modelAndView = new ModelAndView("HomePage");
        return modelAndView;
    }
    @GetMapping(value = "/profile")
    public ModelAndView getAdminProfile(Principal principal){
        ModelAndView modelAndView = new ModelAndView("user/UserProfile");
/**
 * Chung ta co the lay duoc quyen
 */
        UserDetails userDetail = authentication.loadUserByUsername(principal.getName());
        User user = userService.findOneByUsernameAndStatus(principal.getName(),1);

        modelAndView.addObject("userDetail",userDetail);
        modelAndView.addObject("user",user);
        return modelAndView;
    }

    @RequestMapping(value = "/change/infor", method = RequestMethod.GET)
    public ModelAndView showInformationChangePage(Principal principal){
        ModelAndView modelAndView = new ModelAndView("user/UserProfileChange");

        User user = userService.findOneByUsernameAndStatus(principal.getName(),1);

        modelAndView.addObject("user",user);
        return modelAndView;
    }

    @RequestMapping(value = "/change/infor", method = RequestMethod.POST)
    public ModelAndView changeInformation(@ModelAttribute User user, Principal principal){
        ModelAndView modelAndView = new ModelAndView("user/UserProfileChange");

        User currentUser = userService.findOneByUsernameAndStatus(principal.getName(), 1);
        user.setRoleList(currentUser.getRoleList());
        user.setStatus(1);
        userService.save(user);

        modelAndView.addObject("user",user);
        modelAndView.addObject("message","Updated successfully");
        return modelAndView;
    }

    @RequestMapping(value = "/login",method = RequestMethod.GET)
    public String login(){
        return "LoginForm/LoginForm";
    }

    @RequestMapping(value = "/signup",method = RequestMethod.GET)
    public String signUp(){
        return "admin/AdminRegistration";
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