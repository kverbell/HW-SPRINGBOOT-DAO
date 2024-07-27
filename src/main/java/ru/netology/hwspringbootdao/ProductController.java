package ru.netology.hwspringbootdao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {

    @Autowired
    private ProductRepository productRepository;

    @GetMapping("/products/product-script")
    public String fetchProduct(@RequestParam String name) {
        return productRepository.getProductName(name);
    }
}