package com.Grocery.Grocery_ordering_system.Mapper;

import com.Grocery.Grocery_ordering_system.DTO.CustomerDTO;
import com.Grocery.Grocery_ordering_system.Entity.Customer;

public class CustomerMapper {

    public static Customer mapToCustomer(CustomerDTO customerDTO){
        Customer customer = new Customer();
        customer.setId(customerDTO.getId());
        customer.setName(customerDTO.getName());
        customer.setEmail(customerDTO.getEmail());
        customer.setPhone(customerDTO.getPhone());
        return customer;
    }

    public static CustomerDTO mapCustomerDTO(Customer customer){
        CustomerDTO customerDTO = new CustomerDTO();
        customerDTO.setId(customer.getId());
        customerDTO.setName(customer.getName());
        customerDTO.setEmail(customer.getEmail());
        customerDTO.setPhone(customer.getPhone());
        return customerDTO;
    }
}
