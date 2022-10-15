package ru.market.AutumnMarket.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.market.AutumnMarket.product.Product;
import ru.market.AutumnMarket.repositories.ProductRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository repository;

    public Product getProduct(Long id) {
        return repository.findById(id);
    }

    public List<Product> getAllProducts() {
        return repository.getAllProducts();
    }
}
