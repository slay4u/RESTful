package rest.rest.domain;

import lombok.*;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Component
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
public class Order implements Serializable {
    @NonNull
    private long id;

    @NonNull
    private Date date;

    private double cost;

    @NonNull
    private List<Product> products;

    public Order(@NonNull long id, @NonNull Date date, @NonNull List<Product> products) {
        this.id = id;
        this.date = date;
        this.products = products;
        this.cost = products.stream().mapToDouble((Product::getCost)).sum();
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", date=" + date +
                ", cost=" + cost +
                ", products=" + products +
                '}';
    }
}
