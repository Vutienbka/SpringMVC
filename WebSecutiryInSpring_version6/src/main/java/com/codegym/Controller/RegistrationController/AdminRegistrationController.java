package com.codegym.Controller.RegistrationController;

import com.codegym.DTO.Admin.AdminRegistration;
import com.codegym.Entity.User;
import com.codegym.Service.AdminService.IAdminService;
import com.codegym.Service.RoleService.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping(value = "/admin")
public class AdminRegistrationController {
    @Autowired
    public IAdminService adminService;
    @Autowired
    public IRoleService roleService;

    /**
     * Tao admin moi de binding sang view
     */
    @ModelAttribute("admin")
    public AdminRegistration adminRegistration() {
        return new AdminRegistration();
    }

    @GetMapping(value = "/Registration")
    public String showRegistrationForm(Model model) {
        return "admin/AdminRegistration";
    }

    @PostMapping(value = "/Registration")
    public String registerUserAccount(@ModelAttribute("admin") @Valid AdminRegistration adminRegistration ,
                                      BindingResult result) {

        User existingUsername = adminService.findOneByUsernameAndStatus(adminRegistration.getUsername(), adminRegistration.getStatus());
        if (existingUsername != null) {
            result.rejectValue("username", null, "There is already an account registered with that username");
        }

        if (result.hasErrors()) {
            return "admin/AdminRegistration";
        }

        adminService.addRegistrationAdmin(adminRegistration);
        return "LoginForm/LoginForm";
    }

}
