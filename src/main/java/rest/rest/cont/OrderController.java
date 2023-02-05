package rest.rest.cont;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import rest.rest.domain.Order;
import rest.rest.rep.OrderRepository;

import java.util.List;

@RestController
@RequestMapping(value = "/api", produces = "application/json")
@AllArgsConstructor
public class OrderController {

    private final OrderRepository rep;

    @PostMapping("/order/new")
    public Order addNewOrder(Order order) {
        return rep.addOrder(order);
    }

    @GetMapping("/order/all")
    public List<Order> showAllOrders() {
        return rep.getAllOrders();
    }

    @GetMapping("/order/delete/{id}")
    public Order deleteOrderById(@PathVariable("id") long id) {
        return rep.deleteOrderById(id);
    }

    @RequestMapping("/order/searchById/{id}")
    public Order showOrderById(@PathVariable("id") long id) {
        return rep.getOrderById(id);
    }
}
