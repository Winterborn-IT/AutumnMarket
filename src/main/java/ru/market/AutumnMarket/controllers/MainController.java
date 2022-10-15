package ru.market.AutumnMarket.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import ru.market.AutumnMarket.services.ProductService;

@Controller
@RequiredArgsConstructor
public class MainController {

    private final ProductService service;

    //    http://localhost:8189/app/hello
    @GetMapping("/hello")
    @ResponseBody
    public String hello() {
        return "HELLO";
    }

    //    http://localhost:8189/app/calc?first=5&second=2
    @GetMapping("/calc")
    @ResponseBody
    public int calc(@RequestParam(name = "first", required = true, defaultValue = "2") int a, @RequestParam(name = "second", required = true, defaultValue = "3") int b) {
        return a * b;
    }

    //    http://localhost:8189/app/prod/12/info
    @GetMapping("/prod/{id}/info")
    @ResponseBody
    public String info(@PathVariable String id) {
        return "Id = " + id;
    }

    //    http://localhost:8189/app/page
    @GetMapping("/page")
    public String page(Model model, @RequestParam Long id) {
        model.addAttribute("product", service.getProduct(id));
        return "index.html";
    }

    @GetMapping("/products")
    public String getAllProducts(Model model) {
       model.addAttribute("product", service.getAllProducts());
       return "product.html";
    }
}
