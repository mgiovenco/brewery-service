package com.mgiovenco.breweryservice.service;

import com.mgiovenco.breweryservice.web.model.BeerDto;

import java.util.UUID;

public interface BeerService {
    BeerDto getBeerById(UUID beerId);
}
