package com.mgiovenco.breweryservice.service;

import com.mgiovenco.breweryservice.web.model.CustomerDto;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class CustomerServiceImpl implements CustomerService {
    @Override
    public CustomerDto createCustomer(CustomerDto customerDto) {
        return CustomerDto.builder()
                .id(UUID.randomUUID())
                .name("New Customer")
                .build();
    }

    @Override
    public CustomerDto getCustomerById(UUID id) {
        return CustomerDto.builder()
                .id(UUID.randomUUID())
                .name("Bob")
                .build();
    }

    @Override
    public void updateCustomer(UUID id) {
        return;
    }

    @Override
    public void deleteCustomer(UUID id) {
        return;
    }
}
