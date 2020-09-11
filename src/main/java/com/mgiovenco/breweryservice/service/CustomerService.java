package com.mgiovenco.breweryservice.service;

import com.mgiovenco.breweryservice.web.model.CustomerDto;

import java.util.UUID;

public interface CustomerService {
    CustomerDto createCustomer(CustomerDto customerDto);

    CustomerDto getCustomerById(UUID id);

    void updateCustomer(UUID id);

    void deleteCustomer(UUID id);
}
