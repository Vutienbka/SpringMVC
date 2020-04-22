package com.codegym.Controller.AdminController;

import com.codegym.Authentication.Authentication;
import com.codegym.Entity.Book;
import com.codegym.Entity.Categories;
import com.codegym.Entity.User;

import com.codegym.Service.AdminService.IAdminService;
import com.codegym.Service.BookService.IBookService;
import com.codegym.Service.CategoriesService.ICategoriesService;
import com.codegym.Service.UserService.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.ModelAndViewDefiningException;

import java.security.Principal;
import java.util.List;

@Controller
@RequestMapping(value = "/admin")
public class AdminController {

    @Autowired
    Authentication authentication;

    @Autowired
    IAdminService adminService;

    @Autowired
    IUserService userService;

    @Autowired
    IBookService bookService;

    @Autowired
    ICategoriesService categoriesService;

    @RequestMapping(value = "/welcome")
    public ModelAndView welcome(){
        ModelAndView modelAndView = new ModelAndView("admin/HomePage");
        List<Book> bookList = bookService.findAll();
        modelAndView.addObject("bookList",bookList);
        return modelAndView;
    }
    @GetMapping(value = "/profile")
    public ModelAndView getAdminProfile(Principal principal){
        ModelAndView modelAndView = new ModelAndView("admin/profile");
/**
 * Chung ta co the lay duoc quyen
 */
        UserDetails userDetail = authentication.loadUserByUsername(principal.getName());
        User admin = adminService.findOneByUsernameAndStatus(principal.getName(),1);

        modelAndView.addObject("userDetail",userDetail);
        modelAndView.addObject("admin",admin);
        return modelAndView;
    }

    @RequestMapping(value = "change/infor", method = RequestMethod.GET)
    public ModelAndView showInformationChangePage(Principal principal){
        ModelAndView modelAndView = new ModelAndView("admin/ProfileChange");

        User admin = adminService.findOneByUsernameAndStatus(principal.getName(),1);

        modelAndView.addObject("admin",admin);
        return modelAndView;
    }

    @RequestMapping(value = "change/infor", method = RequestMethod.POST)
    public ModelAndView chaneInformation(@ModelAttribute User admin, Principal principal){
        ModelAndView modelAndView = new ModelAndView("admin/ProfileChange");

        User currentAdmin = adminService.findOneByUsernameAndStatus(principal.getName(), 1);
        admin.setRoleList(currentAdmin.getRoleList());
        admin.setStatus(admin.getStatus());
        adminService.save(admin);

        modelAndView.addObject("admin",admin);
        modelAndView.addObject("message","Updated successfully");
        return modelAndView;
    }
    @RequestMapping(value = "/registered-userlist",method = RequestMethod.GET)
    public ModelAndView getUserList(){
        ModelAndView modelAndView = new ModelAndView("admin/UserList");
        List<User> userList = adminService.findUserListByRole(2);
        modelAndView.addObject("userList",userList);
        return modelAndView;
    }

    @RequestMapping(value = "/edit-user/{id}", method = RequestMethod.GET)
    public ModelAndView editUserForm(@PathVariable("id") Long userId){
        User user = userService.findUserById(userId);
        ModelAndView modelAndView = new ModelAndView("admin/EditUser");
        modelAndView.addObject("user",user);
        return modelAndView;
    }

    @RequestMapping(value = "/edit-user",method = RequestMethod.POST)
    public ModelAndView editUser(@ModelAttribute("user") User user){
        ModelAndView modelAndView = new ModelAndView("admin/EditUser");
        User editedUser = userService.save(user);
        if(editedUser==null){
            modelAndView.addObject("message","Edited not successfully");
            return modelAndView;
        }
        modelAndView.addObject("message","Edited successfully");
        modelAndView.addObject("user",editedUser);
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



//    @RequestMapping(value = "/logout")
//    public String logout(){
//        return "/LoginForm/LoginForm";
//    }
}
