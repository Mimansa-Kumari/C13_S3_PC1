package com.example.customerService.service;
import com.example.customerService.domain.Customer;
import com.example.customerService.exception.CustomerDetailsAlreadyPresent;
import com.example.customerService.exception.InvalidCustomerId;
import com.example.customerService.exception.NoSuchProductFoundWithThisName;
import com.example.customerService.repository.ICustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService implements ICustomerService{
    @Autowired
    ICustomerRepository iCustomerRepository;

    public CustomerService(ICustomerRepository iCustomerRepository) {
        this.iCustomerRepository = iCustomerRepository;
    }


    @Override
    public Customer saveCustomerDetails(Customer customer)throws CustomerDetailsAlreadyPresent {
        if(iCustomerRepository.findById(customer.getCustomerId()).isEmpty()) {
            return iCustomerRepository.insert(customer);
        }
        else
        {
            throw new CustomerDetailsAlreadyPresent();
        }
    }

    @Override
    public boolean deleteCustomerDetail(int id)throws InvalidCustomerId {
        iCustomerRepository.deleteById(id);
        return iCustomerRepository.findById(id).isEmpty();
    }

    @Override
    public List<Customer> fetchAllCustomerDetails() {
        return iCustomerRepository.findAll();
    }

    public List<Customer> getCustomerByProductName(String productName)throws NoSuchProductFoundWithThisName
    {
        return iCustomerRepository.getCustomerByProductName(productName);
    }
}
