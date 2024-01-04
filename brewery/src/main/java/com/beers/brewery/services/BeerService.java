package com.beers.brewery.services;

import com.beers.brewery.web.model.BeerDto;
import com.beers.brewery.web.model.CustomerDto;

import java.util.UUID;

public interface BeerService {
    BeerDto getBeerById(UUID beerId);

    BeerDto saveBeer(BeerDto beerDto);

    void updateBeer(UUID beerId, BeerDto beerDto);

    void deleteBeer(UUID beerId);
}
