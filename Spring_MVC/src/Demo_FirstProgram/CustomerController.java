package Demo_FirstProgram;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.lang.annotation.Annotation;

@Controller
public class CustomerController{

    @GetMapping("/CustomerList") // cho servlet "CustomerList"
    public String listCustomer(){
        return "Customers"; //Tra ve mot file View Customers.jsp
    }
    @GetMapping("/ListDetailCustomer")
    public ModelAndView listDetailCustomer(){
        ModelAndView modelAndView = new ModelAndView("DetailCustomer");
        String message = "This is VIP customer";
        modelAndView.addObject("message",message);
        return modelAndView;
    }


}
