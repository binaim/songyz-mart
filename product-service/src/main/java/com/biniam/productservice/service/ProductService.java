package com.biniam.productservice.service;

import com.biniam.productservice.model.Product;
import com.biniam.productservice.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public Product findProductByName(String name){
        Product product = null;
        try {
             product = productRepository.findProductByNameAndAvailabilityExists(name);
        }catch (Exception e){

        }
        return product;
    }
}
