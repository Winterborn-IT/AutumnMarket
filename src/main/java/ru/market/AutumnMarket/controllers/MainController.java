package ru.market.AutumnMarket.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.market.AutumnMarket.product.Product;
import ru.market.AutumnMarket.repositories.ProductRepository;
import ru.market.AutumnMarket.services.ProductService;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class MainController {

    private final ProductService service;

    private final ProductRepository productRepository;

    @GetMapping("/products/change_cost")
    public void changeCost(@RequestParam Long productId, @RequestParam Integer delta) {
        service.changeCost(productId, delta);
    }

    //    http://localhost:8189/app/products/all
    @GetMapping("/products/all")
    public List<Product> getAllProducts() {
       return productRepository.getAllProducts();
    }

}
