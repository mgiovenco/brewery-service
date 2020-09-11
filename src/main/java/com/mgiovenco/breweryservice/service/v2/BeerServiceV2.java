package com.mgiovenco.breweryservice.service.v2;

import com.mgiovenco.breweryservice.web.model.v2.BeerDtoV2;

import java.util.UUID;

public interface BeerServiceV2 {
    BeerDtoV2 handlePost(BeerDtoV2 beerDtoV2);

    BeerDtoV2 getBeerById(UUID beerId);

    void updateBeer(UUID beerId, BeerDtoV2 beerDtoV2);

    void deleteById(UUID beerId);
}
