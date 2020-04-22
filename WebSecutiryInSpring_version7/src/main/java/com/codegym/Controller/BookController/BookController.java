package com.codegym.Controller.BookController;

import com.codegym.DTO.MyCart.Item;
import com.codegym.DTO.MyCart.MyCart;
import com.codegym.DTO.Product.BookResultList;
import com.codegym.DTO.Product.Pagination;
import com.codegym.Entity.Book;
import com.codegym.Entity.Categories;
import com.codegym.Service.BookService.IBookService;
import com.codegym.Service.CategoriesService.ICategoriesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping(value = "/admin")
public class BookController {

    @Autowired
    ICategoriesService categoriesService;

    @Autowired
    IBookService bookService;

    @ModelAttribute("categoryList")
    public List<Categories> getCategoryList() {
        return categoriesService.findAll();
    }

    @RequestMapping(value = "/BookList", method = RequestMethod.GET)
    public ModelAndView showBookList() {
        ModelAndView modelAndView = new ModelAndView("admin/Book/BookList");
        List<Book> bookList = bookService.findAll();
        modelAndView.addObject("bookList", bookList);
        modelAndView.addObject("message", "");
        return modelAndView;
    }


    @RequestMapping(value = "/add-book", method = RequestMethod.GET)
    public ModelAndView addBookForm() {
        ModelAndView modelAndView = new ModelAndView("admin/Book/AddBook");
        modelAndView.addObject("book", new Book());
        return modelAndView;
    }

    @RequestMapping(value = "/add-book", method = RequestMethod.POST)
    public ModelAndView addBook(@Valid @ModelAttribute("book") Book book, BindingResult result) {
        ModelAndView modelAndView = new ModelAndView("admin/Book/AddBook");
        Categories categories = book.getCategories();
        try {
            bookService.addBook(book);
        }catch (Exception e){
            modelAndView.addObject("message","don't add duplicate item");
            return modelAndView;
        }

        if (result.hasErrors()){
            result.rejectValue("code",null,"this field must be unique");
        }

        modelAndView.addObject("message", "New book created successfully");
        return modelAndView;
    }

    @RequestMapping(value = "/edit-book/{id}", method = RequestMethod.GET)
    public ModelAndView editBookForm(@PathVariable("id") Long bookId){
        Book book = bookService.findById(bookId);
        ModelAndView modelAndView = new ModelAndView("/admin/Book/EditBook");
        modelAndView.addObject("book",book);
        return modelAndView;
    }

    @RequestMapping(value = "/edit-book", method = RequestMethod.POST)
    public ModelAndView editBook(@ModelAttribute("book") Book book){
        ModelAndView modelAndView = new ModelAndView("/admin/Book/EditBook");
        try {
            Book updatedBook = bookService.update(book);
            if(updatedBook!=null)
                modelAndView.addObject("message","Updated successfully");
        }catch (Exception e){
            modelAndView.addObject("message","You changed to existed item");
            return modelAndView;
        }

        return modelAndView;
    }

    @RequestMapping(value = "/delete-book/{id}", method = RequestMethod.GET)
    public ModelAndView deleteBookForm(@PathVariable("id") Long bookId){
        ModelAndView modelAndView;
        Book book = bookService.findById(bookId);
        if(book != null) {
            modelAndView = new ModelAndView("admin/Book/DeleteBook");
            modelAndView.addObject("book", book);

        }else {
            modelAndView = new ModelAndView("admin/Book/error404");
        }
        return modelAndView;
    }

    @RequestMapping(value = "/delete-book", method = RequestMethod.POST)
    public ModelAndView deleteBook(@ModelAttribute("book") Book book){
        ModelAndView modelAndView = new ModelAndView("admin/Book/BookList");
        bookService.remove(book.getId());
        List<Book> bookList = bookService.findAll();
        modelAndView.addObject("message", "Deleted successfully");
        modelAndView.addObject("bookList",bookList);
        return modelAndView;
    }
    @RequestMapping(value = "/search",method = RequestMethod.GET)
    public ModelAndView getSearchResult(@RequestParam("search") String search){
        ModelAndView modelAndView = new ModelAndView("/admin/HomePage");
        List<Book> bookList;
        if(search.equalsIgnoreCase("")){
            bookList=bookService.findAll();
            modelAndView.addObject("bookList",bookList);
            return modelAndView;
        }
        bookList=bookService.getSearchResult(search);
        modelAndView.addObject("bookList",bookList);
        return modelAndView;
    }
    @RequestMapping(value = "/getSearch",method = RequestMethod.GET)
    public ModelAndView getSearchTechnology(@RequestParam("getSearch") String search){
        ModelAndView modelAndView = new ModelAndView("/admin/HomePage");
        List<Book> bookList=new ArrayList<>();
        for(Book book: bookService.findAll()){
            if(book.getCategories().getCategoryName().equalsIgnoreCase(search)){
                bookList.add(book);
            }
        }
        if (bookList==null) {
            modelAndView.addObject("bookList", bookService.findAll());
            return modelAndView;
        }else {
            modelAndView.addObject("bookList", bookList);
        }
        return modelAndView;
    }


}
