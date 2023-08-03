package com.example.customerService.controller;

import com.example.customerService.domain.Customer;
import com.example.customerService.exception.CustomerDetailsAlreadyPresent;
import com.example.customerService.exception.InvalidCustomerId;
import com.example.customerService.exception.NoSuchProductFoundWithThisName;
import com.example.customerService.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class CustomerController {
    @Autowired
    CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    //http://localhost:63300/api/v1/addCustomer
    @PostMapping("/addCustomer")
    public ResponseEntity<?> saveCustomerDetails(@RequestBody Customer customer) throws CustomerDetailsAlreadyPresent {
        Customer customer1 = customerService.saveCustomerDetails(customer);
        return new ResponseEntity<>(customer1, HttpStatus.CREATED);
    }

    //http://localhost:63300/api/v1/delBy/3
    @DeleteMapping("/delBy/{id}")
    public ResponseEntity<?> deleteCustomerDetail(@PathVariable int id)throws InvalidCustomerId
    {
        Boolean flag = customerService.deleteCustomerDetail(id);
        return new ResponseEntity<>(flag,HttpStatus.OK);
    }

    //http://localhost:63300/api/v1/getCustomers
    @GetMapping("/getCustomers")
    public ResponseEntity<?>fetchAllCustomerDetails()
    {
        List<Customer> list = customerService.fetchAllCustomerDetails();
        return new ResponseEntity<>(list,HttpStatus.OK);
    }

    @GetMapping("/getCustomersBy/{productName}")
    public ResponseEntity<?> getCustomerByProductName(@PathVariable String productName)throws NoSuchProductFoundWithThisName
    {
        List<Customer> list = customerService.getCustomerByProductName(productName);
        return new ResponseEntity<>(list,HttpStatus.OK);
    }
}
