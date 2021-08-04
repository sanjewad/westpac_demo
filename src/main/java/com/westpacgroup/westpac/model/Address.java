package com.westpacgroup.westpac.model;

import lombok.*;


@AllArgsConstructor
@Getter
@Setter
@Data
@Builder
@EqualsAndHashCode
public class Address {
    private  String street;
    private String suite;
    private String city;
    private String zipcode;
    private Geo geo;

    public Address(){}
}

