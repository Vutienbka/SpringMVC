package com.codegym.Controller.AccountController;

import com.codegym.Model.UserAccount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Controller
public class AccountController {
    @Autowired
    HttpSession session;

    @GetMapping(value = "/sign-in")
    public ModelAndView showSignInForm(@CookieValue(defaultValue = "") String userName, @CookieValue(defaultValue = "") String password){
        ModelAndView modelAndView = new ModelAndView("SignIn/SignIn");
        modelAndView.addObject("userName",userName);
        modelAndView.addObject("password",password);
        modelAndView.addObject("message", "");
        return modelAndView;
    }

    @PostMapping(value = "/sign-in")
    public ModelAndView signIn(@ModelAttribute UserAccount userAccount,
                               @RequestParam(defaultValue = "") String rememberMe, HttpServletResponse response) {
        ModelAndView modelAndView = new ModelAndView("/SignIn/SignIn");

        if ((userAccount.getUserName().equalsIgnoreCase("VutienBka")) && (userAccount.getPassword().equals("123456"))) {
            session.setAttribute("isSignedIn",true);

            if (rememberMe.equalsIgnoreCase("remember-me")) {
                Cookie userName = new Cookie("userName", userAccount.getUserName());
                Cookie password = new Cookie("password", userAccount.getPassword());

                response.addCookie(userName);
                response.addCookie(password);

                modelAndView.addObject("message", "Sign in successful");
            }
        } else {
            modelAndView.addObject("message", "Sign in not successful");
        }
        return modelAndView;
    }

}
