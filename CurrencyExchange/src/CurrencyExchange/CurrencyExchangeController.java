package CurrencyExchange;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class CurrencyExchangeController {
    @GetMapping("/showCurrencyExchangeForm")
    public ModelAndView showCurrencyExchangeForm(HttpServletRequest request, HttpServletResponse response){
        ModelAndView modelAndView = new ModelAndView("CurrencyExchangeForm");
        return modelAndView;
    }
    @GetMapping("/showCurrencyExchangeFormAfterCalculate")
    public ModelAndView currencyExchange(HttpServletRequest request, HttpServletResponse response){
        int usd = Integer.parseInt(request.getParameter("usd"));
        int rate = Integer.parseInt(request.getParameter("rate"));
        int result = usd * rate;
        String results = String.valueOf(result);
        ModelAndView modelAndView = new ModelAndView("CurrencyExchangeForm");
        modelAndView.addObject("usd",usd);
        modelAndView.addObject("rate",rate);
        modelAndView.addObject("result",results);
        return modelAndView;
    }
}
