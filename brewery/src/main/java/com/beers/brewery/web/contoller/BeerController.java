package com.beers.brewery.web.contoller;

import com.beers.brewery.services.BeerService;
import com.beers.brewery.web.model.BeerDto;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("api/v1/beer")
public class BeerController {
    private final BeerService beerService;

    public BeerController(BeerService beerService) {
        this.beerService = beerService;
    }

    @GetMapping({"/{beerId}"})
    public ResponseEntity<BeerDto> getBeerById(@PathVariable UUID beerId) {
        return new ResponseEntity<>(beerService.getBeerById(beerId), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<String> handlePost(@RequestBody BeerDto beerDto) {
        BeerDto savedDto = beerService.saveBeer(beerDto);

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("Location", "api/v1/beer" + savedDto.getId().toString());

        return new ResponseEntity<>(httpHeaders, HttpStatus.CREATED);
    }

    @PutMapping({"/{beerId}"})
    public ResponseEntity<String> handleUpdate(@PathVariable UUID beerId, @RequestBody BeerDto beerDto) {
        beerService.updateBeer(beerId, beerDto);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }

    @DeleteMapping({"/{beerId}"})
    @ResponseStatus(HttpStatus.OK)
    public void deleteBeer(@PathVariable UUID beerId) {
        beerService.deleteBeer(beerId);
    }
}
