package com.biniam.productservice.repository;

import com.biniam.productservice.model.Product;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends MongoRepository<Product, String> {

    Product findProductByAvailability(boolean availability);
    Product findProductById(String id);
    Product findProductByNameAndAvailabilityExists(String name);

}
