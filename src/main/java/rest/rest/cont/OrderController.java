package rest.rest.cont;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import rest.rest.domain.Order;
import rest.rest.rep.OrderRepository;

import java.util.List;

@RestController
@RequestMapping(value = "/order", produces = "application/json")
@AllArgsConstructor
public class OrderController {

    private final OrderRepository rep;

    @PostMapping("/new")
    public Order addNewOrder(Order order) {
        return rep.addOrder(order);
    }

    @GetMapping("/all")
    public List<Order> showAllOrders() {
        return rep.getAllOrders();
    }

    @RequestMapping("/searchById/{id}")
    public Order showOrderById(@PathVariable("id") long id) {
        return rep.getOrderById(id);
    }
}
