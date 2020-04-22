package com.codegym.Controller.HomeController;

import com.codegym.DTO.Product.BookResultList;
import com.codegym.DTO.Product.Pagination;
import com.codegym.Entity.Book;
import com.codegym.Service.BookService.IBookService;
import com.codegym.Service.CategoriesService.ICategoriesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {
    @Autowired
    ICategoriesService categoriesService;

    @Autowired
    IBookService bookService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView BooksList(@RequestParam(defaultValue = "6") int size, @RequestParam(defaultValue = "0") int page) {
        ModelAndView modelAndView = new ModelAndView("HomePage");
        Page<Book> bookList = this.bookService.getAllBooks("", size, page);

        BookResultList bookResultList = new BookResultList();
        bookResultList.setData(bookList.getContent());

        Pagination pagination = new Pagination();
        pagination.setPage(page);
        pagination.setSize(size);
        pagination.setTotal(bookList.getTotalElements());

        bookResultList.setPagination(pagination);
        modelAndView.addObject("bookList",bookList);
        return modelAndView;
    }

    @RequestMapping(value = "/HomePage", method = RequestMethod.GET)
    public String getBooksList(@RequestParam(defaultValue = "6") int size, @RequestParam(defaultValue = "0") int page) {
        return "redirect:/";
    }


    @GetMapping("/BookList")
    public ModelAndView getBookListByName(@RequestParam("getsearch") String search, @RequestParam(defaultValue = "6") int size, @RequestParam(defaultValue = "0") int page) {
        ModelAndView modelAndView = new ModelAndView("HomePage");
        Page<Book> bookList = this.bookService.getAllBooks(search, size, page);

        BookResultList bookResultList = new BookResultList();
        bookResultList.setData(bookList.getContent());

        Pagination pagination = new Pagination();
        pagination.setPage(page);
        pagination.setSize(size);
        pagination.setTotal(bookList.getTotalElements());

        bookResultList.setPagination(pagination);
        modelAndView.addObject("bookList",bookList);
        return modelAndView;
    }

    @GetMapping("/BookList/{name}")
    public ModelAndView getBookListByCategory(@PathVariable("name") String search, @RequestParam(defaultValue = "6") int size, @RequestParam(defaultValue = "0") int page) {
        ModelAndView modelAndView = new ModelAndView("HomePage");
        Page<Book> bookList = this.bookService.getAllBooksWithCategory(search, size, page);

        BookResultList bookResultList = new BookResultList();
        bookResultList.setData(bookList.getContent());

        Pagination pagination = new Pagination();
        pagination.setPage(page);
        pagination.setSize(size);
        pagination.setTotal(bookList.getTotalElements());

        bookResultList.setPagination(pagination);
        modelAndView.addObject("bookList",bookList);
        return modelAndView;
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
