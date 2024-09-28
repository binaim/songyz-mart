package com.biniam.productservice.controller;

import com.biniam.productservice.model.Product;
import com.biniam.productservice.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1.0/products")
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping("/{name}")
    public Product getProductByNameIfExists(@PathVariable String name){

        return productService.findProductByName(name);
//        return "I am alive";
    }

    @GetMapping
    public List<Product> getAllProducts(){

        return productService.getAllProducts();
    }

    @GetMapping("/{id}")
    public Product getProductById(@PathVariable String id){
        return productService.findProductById(id);
    }
    @PostMapping
    public Product createProduct(@RequestBody Product product){
        return productService.createProduct(product);
    }
//    create a putmapping api/v1.0/products/{id} to update a product
    @PutMapping("/{id}")
    public Product updateProduct(@PathVariable String id, @RequestBody Product product){
        return productService.updateProduct(id, product);

    }

}
