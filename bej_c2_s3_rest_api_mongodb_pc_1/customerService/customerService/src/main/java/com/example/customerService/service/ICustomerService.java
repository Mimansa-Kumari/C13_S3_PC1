package com.example.customerService.service;

import com.example.customerService.domain.Customer;
import com.example.customerService.exception.CustomerDetailsAlreadyPresent;
import com.example.customerService.exception.InvalidCustomerId;
import com.example.customerService.exception.NoSuchProductFoundWithThisName;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

public interface ICustomerService {
    public Customer saveCustomerDetails(Customer customer)throws CustomerDetailsAlreadyPresent;
    public boolean deleteCustomerDetail(int id)throws InvalidCustomerId;
    public List<Customer> fetchAllCustomerDetails();
    public List<Customer> getCustomerByProductName(String productName)throws NoSuchProductFoundWithThisName;
}
