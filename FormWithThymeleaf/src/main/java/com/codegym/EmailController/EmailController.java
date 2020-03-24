package com.codegym.EmailController;

import com.codegym.Model.EmailBox;
import com.codegym.Service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;

@Controller
public class EmailController {
    @Autowired
    EmailService emailService;

    @RequestMapping(value = "/emailBoxForm")
    public String gotoEmailBoxForm(Model model){
        model.addAttribute("emailBox", new EmailBox());
        ArrayList<String> languageList = new ArrayList<>();
        languageList.add("English");
        languageList.add("Vietnamese");
        languageList.add("Japanese");
        languageList.add("Chinese");
        languageList.add("Korea");
        model.addAttribute("languageList",languageList);

        ArrayList<String> pageSizeList = new ArrayList<>();
        pageSizeList.add("5");
        pageSizeList.add("10");
        pageSizeList.add("15");
        pageSizeList.add("20");
        pageSizeList.add("25");
        model.addAttribute("pageSizeList", pageSizeList);
        return "EmailBox";
    }

    @RequestMapping(value = "/submit", method = RequestMethod.POST)
    public String updateEmailBox(@ModelAttribute("emailBox") EmailBox emailBox, Model model){
        model.addAttribute("emailBox", emailBox);
        return "UpdateInformation";
    }

}
