package com.biniam.productservice.repository;

import com.biniam.productservice.model.Variant;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface VariantRepository extends MongoRepository<Variant, String> {

}
