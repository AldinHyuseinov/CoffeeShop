package bg.softuni.coffeeshop.web;

import bg.softuni.coffeeshop.models.dto.AddOrderDTO;
import bg.softuni.coffeeshop.services.OrderService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/orders")
@AllArgsConstructor(onConstructor_ = @Autowired)
public class OrderController {
    private final OrderService orderService;

    @GetMapping("/add")
    public String addOrder() {
        return "order-add";
    }

    @ModelAttribute("orderModel")
    public AddOrderDTO initOrder() {
        return new AddOrderDTO();
    }

    @PostMapping("/add")
    public String addOrder(@Valid AddOrderDTO orderModel, BindingResult bindingResult,
                           RedirectAttributes redirectAttributes) {

        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("orderModel", orderModel);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.orderModel",
                    bindingResult);
            return "redirect:/orders/add";
        }
        orderService.addOrder(orderModel);

        return "redirect:/home";
    }

    @GetMapping("/ready")
    public String orderReady(@RequestParam Long orderId) {
        orderService.deleteOrder(orderId);

        return "redirect:/home";
    }
}
