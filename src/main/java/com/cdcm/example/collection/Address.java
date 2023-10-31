package com.cdcm.example.collection;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Address {
    private String country;
    private String city;
    private String street;
}
