package com.biniam.productservice.controller;

import com.biniam.productservice.model.Product;
import com.biniam.productservice.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1.0/products/")
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping("{name}")
    public Product getProductByNameIfExists(@PathVariable String name){

        return productService.findProductByName(name);
    }
}
