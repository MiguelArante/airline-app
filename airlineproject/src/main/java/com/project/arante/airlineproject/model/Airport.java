package com.project.arante.airlineproject.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Airport {

    private String name;
    private String iata_code;
    private String country_code;
    private String lat;
    private String lng;
    
}
