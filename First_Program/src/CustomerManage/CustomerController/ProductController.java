package CustomerManage.CustomerController;

import CustomerManage.CustomerService.CustomerService;
import CustomerManage.Model.Customer;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;

@Controller
public class ProductController {
    CustomerService customerService = new CustomerService();

    @GetMapping("/customerList")
    public ModelAndView showCustomerList(){
        ArrayList<Customer> customerList = new ArrayList<>();
        customerList=customerService.selectAllCustomer();
        ModelAndView modelAndView = new ModelAndView("CustomerList");
        modelAndView.addObject("customerList", customerList);
        return modelAndView;
    }
    @GetMapping("/addCustomerForm")
    public ModelAndView showCustomerForm(){
        ModelAndView modelAndView = new ModelAndView("AddCustomerForm");
        return modelAndView;
    }

    @GetMapping("/listCustomerAfterAdded")
    public ModelAndView addCustomer(HttpServletRequest request, HttpServletResponse response){
        int customerId = Integer.parseInt(request.getParameter("customerId"));
        String customerName = request.getParameter("customerName");
        String email = request.getParameter("email");
        String address = request.getParameter("address");
        Customer customer = new Customer(customerId,customerName,email,address);
        ArrayList<Customer> customerList;
        customerService.selectAllCustomer();
        customerService.addCustomer(customer);
        customerList=customerService.selectAllCustomer();
        ModelAndView modelAndView = new ModelAndView("CustomerList");
        modelAndView.addObject("customerList", customerList);
        return modelAndView;
    }

}
