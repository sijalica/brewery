package com.beers.brewery.web.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@Builder
public class CustomerDto {
    private UUID id;
    private String name;
}
