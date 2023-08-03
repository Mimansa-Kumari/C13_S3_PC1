package com.example.customerService.repository;

import com.example.customerService.domain.Customer;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface ICustomerRepository extends MongoRepository<Customer,Integer> {
    @Query("{'product.productName' : { $eq : ?0 }}")
    public List<Customer> getCustomerByProductName(String productName);
}
