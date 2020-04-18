package com.codegym.Controller;

import com.codegym.Authentication.Authentication;
import com.codegym.Entity.Book;
import com.codegym.Entity.User;
import com.codegym.Repository.IUserRepository;
import com.codegym.Service.AdminService.IPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
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
    IUserRepository userRepository;

    @Autowired
    IPostService postService;

    @RequestMapping(value = "/welcome")
    public String welcome(){
        return "admin/HomePage";
    }
    @GetMapping(value = "/profile")
    public ModelAndView getAdminProfile(Principal principal){
        ModelAndView modelAndView = new ModelAndView("admin/profile");
        UserDetails userDetail = authentication.loadUserByUsername(principal.getName());
        User user = userRepository.findOneByUsernameAndStatus(principal.getName(),1);
        modelAndView.addObject("admin",userDetail);
        modelAndView.addObject("user",user);
        return modelAndView;
    }

    @RequestMapping(value = "api/post/list",method = RequestMethod.GET)
    public ResponseEntity<List<Book>> getPostList(){
        return null;
    }



//    @RequestMapping(value = "/logout")
//    public String logout(){
//        return "/LoginForm/LoginForm";
//    }
}
