package com.codegym.Controller.ProvinceController;

import com.codegym.Model.Customer;
import com.codegym.Model.Province;
import com.codegym.Service.CustomerService.ICustomerService;
import com.codegym.Service.ProvinceService.IProvinceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Optional;

@Controller
public class ProvinceController {

    IProvinceService provinceService;
    ProvinceController(IProvinceService provinceService){
        this.provinceService = provinceService;
    }

    @Autowired
    ICustomerService customerService;

    @RequestMapping(value = "Province")
    public String gotoHomepage(){
        return "Province/ProvinceList";
    }

    @RequestMapping(value = "province/list")
    public ModelAndView listProvinces(){
        ModelAndView modelAndView = new ModelAndView("Province/ProvinceList");
        List<Province> provinceList = provinceService.findAll();
        modelAndView.addObject("provinceList",provinceList);
        return modelAndView;
    }

    @GetMapping("/create-province")
    public ModelAndView showCreateForm(){
        ModelAndView modelAndView = new ModelAndView("Province/createProvince");
        modelAndView.addObject("province", new Province());
        return modelAndView;
    }

    @PostMapping("/create-province")
    public ModelAndView saveProvince(@ModelAttribute("province") Province province){
        boolean check =provinceService.save(province);
        ModelAndView modelAndView = new ModelAndView("Province/createProvince");
        if(check){
            modelAndView.addObject("province", new Province());
            modelAndView.addObject("message", "New province created successfully");
        }else {
            modelAndView.addObject("message", "Add not successful");
        }

        return modelAndView;
    }

    @RequestMapping(value = "province/create")
    public ModelAndView createProvince(@ModelAttribute Province province){
        boolean check = provinceService.save(province);
        ModelAndView modelAndView = new ModelAndView("Province/createProvince");
        if(check){
            modelAndView.addObject("message", "Add successful");
        }else {
            modelAndView.addObject("message", "Add not successful");
        }

        modelAndView.addObject("province",province);
        return modelAndView;
    }

    @RequestMapping(value="edit-province/{id}")
    public ModelAndView showEditForm(@PathVariable("id") Long provinceId){
        Province province = provinceService.findById(provinceId);
        ModelAndView modelAndView;
        if(province!=null){
             modelAndView = new ModelAndView("Province/editProvince");
            modelAndView.addObject("province",province);
            return modelAndView;
        }else {
             modelAndView = new ModelAndView("Province/error404");
            return modelAndView;
        }
    }
    @RequestMapping(value = "edit-province")
    public ModelAndView editProvince(@ModelAttribute Province province){
        provinceService.save(province);
        ModelAndView modelAndView = new ModelAndView("Province/editProvince");
        modelAndView.addObject("message","Edit successful");
        modelAndView.addObject("province",province);
        return modelAndView;
    }

    @GetMapping("delete-province/{id}")
    public ModelAndView showDeleteForm(@PathVariable("id") Long provinceId){
        Province province = provinceService.findById(provinceId);
        ModelAndView modelAndView;
        if(province != null) {
             modelAndView = new ModelAndView("Province/deleteProvince");
            modelAndView.addObject("province", province);
            return modelAndView;
        }else {
             modelAndView = new ModelAndView("Province/error404");
            return modelAndView;
        }
    }

    @PostMapping("delete-province")
    public String deleteProvince(@ModelAttribute Province province){
        provinceService.remove(province.getId());
        return "redirect:province/list";
    }


    @GetMapping(value = "view-province/{id}")
    public ModelAndView viewProvince(@PathVariable("id") Long provinceId){
        Province province = provinceService.findById(provinceId);
        ModelAndView modelAndView = new ModelAndView("Province/viewProvince");
        modelAndView.addObject("province",province);
        List<Customer> customers = customerService.findAllByProvince(province);
        modelAndView.addObject("province", province);
        modelAndView.addObject("customers", customers);
        return modelAndView;
    }

}
