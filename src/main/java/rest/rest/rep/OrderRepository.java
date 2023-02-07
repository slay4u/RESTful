package rest.rest.rep;

import org.springframework.stereotype.Repository;
import rest.rest.domain.Order;
import rest.rest.domain.Product;

import java.util.*;
import java.util.stream.Collectors;

@Repository
public class OrderRepository {
    private final List<Product> products1 = Arrays.asList(new Product(1, "Mouse", 1600.99), new Product(2, "Keyboard", 2560.90),
            new Product(3, "Chair", 14050.50), new Product(4, "Table", 6500.00), new Product(5, "Monitor", 8750.99));

    private final List<Product> products2 = Arrays.asList(new Product(6, "Car", 160000.99), new Product(7, "Bicycle", 33560.90),
            new Product(8, "Motorcycle", 64050.50), new Product(9, "Bus", 99000.00));

    private final List<Product> products3 = Arrays.asList(new Product(10, "iPhone", 4600.99), new Product(11, "MacBook", 10000.90),
            new Product(12, "iPad", 7939.50));

    private Date date = new Date();
    private List<Order> orders = new ArrayList<>(Arrays.asList(new Order(1, date, products1), new Order(2, date , products2),
            new Order(3, date, products3)));

    public Order addOrder(Order order) {
        orders.add(order);
        return order;
    }

    public Order getOrderById(long id) {
        return orders.stream().filter(o -> o.getId() == id).findAny().get();
    }

    public List<Order> getAllOrders() {
        return orders.stream()
                .sorted(Comparator.comparingLong(Order::getId))
                .collect(Collectors.toList());
    }
}
