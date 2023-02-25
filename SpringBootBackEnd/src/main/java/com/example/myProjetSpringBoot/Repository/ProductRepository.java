package com.example.myProjetSpringBoot.Repository;

import com.example.myProjetSpringBoot.Entity.Product;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

public interface ProductRepository extends MongoRepository<Product,String> {
    @Query("{'name': ?0}")
    Product findByName(String name);
}
