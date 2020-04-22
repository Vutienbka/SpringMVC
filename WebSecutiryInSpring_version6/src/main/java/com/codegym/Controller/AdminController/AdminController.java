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
    IAdminService adminService;

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



    @RequestMapping(value = "/BookList",method = RequestMethod.GET)
    public ModelAndView showBookList(){
        ModelAndView modelAndView = new ModelAndView("admin/Book/BookList");
        List<Book> bookList = bookService.findAll();
        modelAndView.addObject("bookList",bookList);
        modelAndView.addObject("message","");
        return modelAndView;
    }
/*----------------------------BOOK------------------------*/
    @RequestMapping(value = "/add-book",method = RequestMethod.GET)
    public ModelAndView addBookForm(){
        ModelAndView modelAndView = new ModelAndView("admin/Book/AddBook");
        modelAndView.addObject("book",new Book());
        modelAndView.addObject("category",new Categories());
        return modelAndView;
    }



//    @RequestMapping(value = "/add-book",method = RequestMethod.POST)
//    public ModelAndView addBook(@ModelAttribute("book") Book book, @ModelAttribute("category") Categories category ){
//        ModelAndView modelAndView = new ModelAndView("admin/Book/AddBook");
//        Categories currentCategory = categoriesService.addCategory(category,book);
//        if(currentCategory!=null) {
//            modelAndView.addObject("message", "Added successfully");
//            modelAndView.addObject("book",book);
//            modelAndView.addObject("category",category);
//        }else {
//            modelAndView.addObject("message", "Added not successfully");
//        }
//        return modelAndView;
//    }
/*------------------------------------BOOK---------------------------*/



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
