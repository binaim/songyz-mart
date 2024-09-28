package com.biniam.productservice.service;

import com.biniam.productservice.model.Product;
import com.biniam.productservice.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public Product findProductByName(String name){
        Product product = null;
        try {
             product = productRepository.findProductByName(name);
        }catch (Exception e){

        }
        return product;
    }

    public Product createProduct(Product product) {

        return productRepository.save(product);

    }

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public Product findProductById(String id) {
        return productRepository.findProductById(id);
    }

    public Product updateProduct(String id, Product product) {
        Product product1 = productRepository.findProductById(id);
        product1.setName(product.getName());
        product1.setPrice(product.getPrice());
        product1.setDescription(product.getDescription());
        return productRepository.save(product1);

    }
}
