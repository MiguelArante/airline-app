package com.project.arante.airlineproject.modelwrapper;

import java.util.List;

import com.project.arante.airlineproject.model.Flight;

import lombok.Getter;
import lombok.Setter;

/**
 * Response Class Wrapper for Airlabs API
 */
@Getter
@Setter
public class FlightWrapper {

    private List<Flight> response; // response is the name of the field from Airlabs API response, contains list of flights
    
}
