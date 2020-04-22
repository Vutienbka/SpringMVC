package com.codegym.Controller.UserController;

import com.codegym.Authentication.Authentication;
import com.codegym.DTO.MyCart.Item;
import com.codegym.DTO.MyCart.MyCart;
import com.codegym.Entity.Book;
import com.codegym.Entity.User;
import com.codegym.Service.BookService.IBookService;
import com.codegym.Service.UserService.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping(value = "/user")
public class UserController {
    @Autowired
    HttpSession session;

    @Autowired
    Authentication authentication;

    @Autowired
    IUserService userService;

    @Autowired
    IBookService bookService;

    @RequestMapping(value = "/homepage")
    public ModelAndView homepage(){
        ModelAndView modelAndView = new ModelAndView("HomePage");

        List<Book> bookList = bookService.findAll();
        modelAndView.addObject("bookResultList", bookList);
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

    @RequestMapping(value = "/add-cart/{id}")
    public ModelAndView addCart(@PathVariable("id") Long productId, @ModelAttribute("myCart") MyCart myCart, Model model) {
        int quantity = 1;
        double totalPrice = 0.0f;
        ModelAndView modelAndView;
        Book book = bookService.findById(productId);
        myCart = (MyCart) session.getAttribute("myCart");
        if (book != null) {
            if (book.getQuantity() != 0) {
                if (myCart == null) {
                    myCart = new MyCart();
                    List<Item> itemList = new ArrayList<>();
                    Item item = new Item();
                    item.setBook(book);
                    item.setPrice(book.getPrice());
                    item.setQuantity(quantity);
                    itemList.add(item);
                    myCart.setItemList(itemList);
                    session.setAttribute("myCart", myCart);
                    model.addAttribute("myCart", myCart);

                } else {
                    myCart = (MyCart) session.getAttribute("myCart");
                    List<Item> itemList = myCart.getItemList();
                    boolean check = false;
                    for (Item item : itemList) {
                        if (item.getBook().getId() == book.getId()) {
                            item.setQuantity(item.getQuantity() + quantity);
                            check = true;
                        }
                    }
                    if (check == false) {
                        Item item = new Item();
                        item.setQuantity(quantity);
                        item.setBook(book);
                        item.setPrice(book.getPrice());
                        itemList.add(item);
                    }
                    session.setAttribute("myCart", myCart);
                    model.addAttribute("myCart", myCart);
                }

            }

            for(Item item : myCart.getItemList()){
                totalPrice+= item.getQuantity()*item.getBook().getPrice();
            }
            modelAndView = new ModelAndView("user/MyCart");
            modelAndView.addObject("totalPrice",totalPrice);
            return modelAndView;

        } else {
            for(Item item : myCart.getItemList()){
                totalPrice+= item.getQuantity()*item.getBook().getPrice();
            }
            modelAndView = new ModelAndView("user/MyCart");
            modelAndView.addObject("totalPrice",totalPrice);
            return modelAndView;
        }
    }

    @RequestMapping(value = "/view-myCart")
    public ModelAndView viewMyCart(@ModelAttribute("myCart") MyCart myCart){
        ModelAndView modelAndView = new ModelAndView("user/MyCart");
        myCart = (MyCart) session.getAttribute("myCart");
        modelAndView.addObject("myCart", myCart);
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


}