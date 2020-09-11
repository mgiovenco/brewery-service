package com.mgiovenco.breweryservice.service;

import com.mgiovenco.breweryservice.web.model.BeerDto;

import java.util.UUID;

public interface BeerService {
    BeerDto handlePost(BeerDto beerDto);

    BeerDto getBeerById(UUID beerId);

    void updateBeer(UUID beerId, BeerDto beerDto);

    void deleteById(UUID beerId);
}
