package com.project.arante.airlineproject.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * Model of Indiviual Flight Objects within Flight List or FlightWrapper
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Flight {
    
    private String flight_number; 
    private String airline_iata; 
    private String aircraft_icao;
    private String dep_iata;
    private String arr_iata;
    private String status;
    private String departure_time;
    private String arrival_time;

    
}
