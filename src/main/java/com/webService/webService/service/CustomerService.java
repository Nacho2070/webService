package com.webService.webService.service;

import com.webService.webService.DTOs.CustomerDto;
import com.webService.webService.exception.exceptions.CustomerExists;
import com.webService.webService.exception.exceptions.CustomerNotFound;
import com.webService.webService.persistence.CustomerRepository;
import com.webService.webService.persistence.entity.Customer;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class CustomerService {

    private final CustomerRepository customerRepository;

    public List<Customer> getAllCustomers() {
        List<Customer> allCustomers = customerRepository.findAll();
        if (allCustomers.isEmpty()) {
            throw new CustomerNotFound("There is no customers in the database");
        }
        return allCustomers;
    }

    public CustomerDto getCustomerById(Long id) {
        Customer customer = customerRepository.findById(id).orElseThrow(()->
                new CustomerNotFound("Customer with id: " + id + " not found"));
        CustomerDto customerDto = new CustomerDto(customer.getName(), customer.getEmail(),customer.getPhone());
        return customerDto;
    }

    public Customer createCustomer(CustomerDto customerRequest) {
        Customer customerOp = customerRepository.findByEmail(customerRequest.email());

        if (customerOp != null) {
            throw new CustomerExists("Customer with email: " + customerRequest.email() + " already exists");
        }

        Customer customer = Customer.builder()
                .name(customerRequest.name())
                .email(customerRequest.email())
                .phone(customerRequest.phoneNumber())
                .build();

        return customerRepository.save(customer);


    }

    public Customer updateCustomer(Long id, CustomerDto customerDetails) {
        Customer customerFromDb = customerRepository.findById(id).orElseThrow(()->
                new CustomerNotFound("Customer with id: " + id + " not found"));

        customerFromDb.setName(customerDetails.name());
        customerFromDb.setEmail(customerDetails.email());
        if (customerDetails.phoneNumber() != null) {
            customerFromDb.setPhone(customerDetails.phoneNumber());
        }

        //Save again in database
        return customerRepository.save(customerFromDb);
    }

    public void deleteCustomer(Long id) {
        try {
            customerRepository.deleteById(id);
        }catch (Exception e) {
            throw new CustomerNotFound("Customer with id: " + id + " not found");
        }
    }
}

