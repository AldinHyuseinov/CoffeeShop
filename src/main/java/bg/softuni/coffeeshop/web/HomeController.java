package bg.softuni.coffeeshop.web;

import bg.softuni.coffeeshop.services.OrderService;
import bg.softuni.coffeeshop.services.UserService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@AllArgsConstructor(onConstructor_ = @Autowired)
public class HomeController {
    private final OrderService orderService;

    private final UserService userService;

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/home")
    public String home(Model model) {
        model.addAttribute("orders", orderService.allOrders());
        model.addAttribute("timeToPrepare", orderService.timeToPrepareAllOrders());
        model.addAttribute("employeeOrders", userService.ordersByEmployee());

        return "home";
    }
}
