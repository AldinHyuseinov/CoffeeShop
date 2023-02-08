package bg.softuni.coffeeshop.services;

import bg.softuni.coffeeshop.models.dto.AddOrderDTO;
import bg.softuni.coffeeshop.models.dto.ShowOrderDTO;
import bg.softuni.coffeeshop.models.entities.Order;
import bg.softuni.coffeeshop.repositories.CategoryRepository;
import bg.softuni.coffeeshop.repositories.OrderRepository;
import bg.softuni.coffeeshop.utils.user.CurrentUser;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor(onConstructor_ = @Autowired)
public class OrderService {
    private final OrderRepository orderRepository;

    private final CategoryRepository categoryRepository;

    private CurrentUser currentUser;

    private final ModelMapper mapper;

    public void addOrder(AddOrderDTO orderDTO) {
        Order order = mapper.map(orderDTO, Order.class);
        order.setCategory(categoryRepository.findByName(orderDTO.getCategoryName()));
        order.setEmployee(currentUser.getUser());

        orderRepository.saveAndFlush(order);
    }

    public List<ShowOrderDTO> allOrders() {
        return orderRepository.findAll().stream().map(order -> mapper.map(order, ShowOrderDTO.class))
                .sorted(Comparator.comparing(ShowOrderDTO::getPrice).reversed())
                .collect(Collectors.toList());
    }

    public int timeToPrepareAllOrders() {
        return orderRepository.findAll().stream().map(order -> order.getCategory().getNeededTime())
                .mapToInt(Integer::intValue).sum();
    }

    public void deleteOrder(Long id) {
        orderRepository.deleteById(id);
    }
}
