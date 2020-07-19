package com.mgiovenco.breweryservice.service;

import com.mgiovenco.breweryservice.web.model.CustomerDto;

import java.util.UUID;

public interface CustomerService {
    CustomerDto getCustomerById(UUID id);
}
