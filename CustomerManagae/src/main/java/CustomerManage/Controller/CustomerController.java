package CustomerManage.Controller;

import CustomerManage.Model.Customer;
import CustomerManage.Service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import java.util.ArrayList;

@Controller
public class CustomerController {
    @Autowired
    CustomerService customerService;

    @RequestMapping(value = "/customer/list", method = RequestMethod.GET)
    public ModelAndView listCustomer(){
        ArrayList<Customer> customerList = customerService.getAllCustomer();
        ModelAndView modelAndView = new ModelAndView("Customer/customerList");
        modelAndView.addObject("customerList",customerList);
        return modelAndView;
    }

    @GetMapping(value = "/customer/detail/id={customerId}")
    public String getCustomerDetailWithPathVariable(@PathVariable int customerId, Model model){
        //gia tri customerId minh se truyen vao tren duong dan URL vi du: http://localhost:8080/customer/detail/id=2
        ArrayList<Customer> customerList = customerService.getAllCustomer();
        for (Customer customer : customerList){
            if(customer.getCustomerId()==customerId){
                model.addAttribute("customer", customer);
            }
        }
        return "Customer/customerDetail";
    }

    @GetMapping(value = "/customer/detail")
    public String getCustomerDetailWithRequestParam(@RequestParam int customerId, Model model) {
        //gia tri customerId minh se truyen vao tren duong dan URL vi du: http://localhost:8080/customer/detail?customerId=2
        ArrayList<Customer> customerList = customerService.getAllCustomer();
        for (Customer customer : customerList) {
            if (customer.getCustomerId() == customerId) {
                model.addAttribute("customer", customer);
            }
        }
        return "Customer/customerDetail";
    }
    /*Bai ve Gia vi an kem voi Sandwich*/
    @RequestMapping (value = "/save")
    public String showForm(){
        return "Sandwich/Sandwich";
    }

    @RequestMapping (value = "/save/condiment")
    public String getSpice(@RequestParam("condiment")
                                   String[] condiments,
                           Model model){

        for (String condiment: condiments)
            if(condiment!=null){
                model.addAttribute("condiment",condiment);
            }
        return "Sandwich/SpiceWithSandwich";
    }
    /*Bai ve Calculator*/
    @RequestMapping(value = "/calculator")
    public String calculator(){
        return "Calculator/Calculator";
    }

    @RequestMapping(value = "/calculator/result")
    public String calculatorResult(@RequestParam("operator") String operator,
                                   @RequestParam("operand1") float operand1,
                                   @RequestParam("operand2") float operand2,
                                   Model model){
        float result;
        switch (operator){
            case "+":
                result = operand1 + operand2;
                break;
            case "-":
                result = operand1 - operand2;
                break;
            case "*":
                result = operand1*operand2;
                break;
            case "/":
                result = operand1/operand2;
                break;
            default:
                operand1 =0;
                operand2=0;
                result=0;
                break;
        }
        model.addAttribute("operand1",operand1);
        model.addAttribute("operand2",operand2);
        model.addAttribute("result",result);
        return "Calculator/Calculator";
    }

    @RequestMapping(value = "/flashAttribute/result/", method=RequestMethod.GET)
    public RedirectView calculatorResultUsingRedirect(@RequestParam("operator") String operator,
                                                      @RequestParam("operand1") float operand1,
                                                      @RequestParam("operand2") float operand2,
                                                      RedirectAttributes redirectAttributes){
        float result;
        switch (operator){
            case "+":
                result = operand1 + operand2;

                break;
            case "-":
                result = operand1 - operand2;

                break;
            case "*":
                result = operand1*operand2;
                break;
            case "/":
                result = operand1/operand2;
                break;
            default:
                operand1 =0;
                operand2=0;
                result=0;
        }
        redirectAttributes.addFlashAttribute("operand1",operand1);
        redirectAttributes.addFlashAttribute("operand2",operand2);
        redirectAttributes.addFlashAttribute("result",result);

        return new RedirectView("Calculator/Calculator");
    }

}
