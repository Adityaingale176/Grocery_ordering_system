package com.Grocery.Grocery_ordering_system.Service;

import java.util.List;

import com.Grocery.Grocery_ordering_system.DTO.CustomerDTO;

public interface CustomerService{

    CustomerDTO createCustomer(CustomerDTO customerDTO);

    CustomerDTO getCustomerById(Long id);

    CustomerDTO updateCustomerEmail(Long id , String email);

    CustomerDTO deleteCustomer(Long id);

    List<CustomerDTO> getAllCustomer();

}