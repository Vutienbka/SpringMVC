package com.codegym.Controller.RegistrationController;

import com.codegym.DTO.User.UserRegistration;
import com.codegym.Entity.User;
import com.codegym.Repository.IRoleRepository.IRoleRepository;
import com.codegym.Service.RoleService.IRoleService;
import com.codegym.Service.UserService.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class UserRegistrationController {

    @Autowired
    public IUserService userService;
    @Autowired
    public IRoleService roleService;

    /**
     * Tao moi de binding sang view
     */
    @ModelAttribute("user")
    public UserRegistration userRegistration() {
        return new UserRegistration();
    }

    @GetMapping(value = "/Registration")
    public String showRegistrationForm(Model model) {
        return "Registration";
    }

    @PostMapping(value = "/Registration")
    public String registerUserAccount(@ModelAttribute("user") @Valid UserRegistration userRegistration ,
                                      BindingResult result){

        User existing = userService.findOneByUsernameAndStatus(userRegistration.getUsername(),userRegistration.getStatus());
        if (existing != null){
            result.rejectValue("username", null, "There is already an account registered with that email");
        }

        if (result.hasErrors()){
            return "Registration";
        }

        userService.addRegistrationUser(userRegistration);
        return "LoginForm/LoginForm";


//        User existing = userService.findOneByUsernameAndStatus(userRegistration.getUsername(),userRegistration.getStatus());
//        if (existing != null){
//            result.rejectValue("username", null, "There is already an account registered with that email");
//        }
//
//        if (result.hasErrors()){
//            return "Registration";
//        }
//
//        roleService.addUser(userRegistration);
//        return "LoginForm/LoginForm";

    }
}
