package ru.market.AutumnMarket.repositories;

import org.springframework.stereotype.Repository;
import ru.market.AutumnMarket.product.Product;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Repository
public class ProductRepository {
    private List<Product> products;

    @PostConstruct
    public void init() {
        products = new ArrayList<>(Arrays.asList(
                new Product(1L, "Apple", 50),
                new Product(2L, "Orange", 80),
                new Product(3L, "Banana", 70)
        ));
    }

    public Product findById(Long id) {
        return products.stream().filter(p -> p.getId().equals(id)).findFirst().
                orElseThrow(() -> new RuntimeException("id не найден"));
    }

    public List<Product> getAllProducts() {
        return products;
    }
}
