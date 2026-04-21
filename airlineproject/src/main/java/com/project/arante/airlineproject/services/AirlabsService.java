package com.project.arante.airlineproject.services;

import java.util.List;

import com.project.arante.airlineproject.model.Airline;
import com.project.arante.airlineproject.model.Airport;
import com.project.arante.airlineproject.model.Flight;

/**
 * Interface for performing actions on the pages
 * Implementing Classes should override this method
 */
public interface AirlabsService {
    
    public List<Airline> viewAirlines();
    public List<Airport> viewAirports();
    public List<Flight> searchFlight(String dep_iata);


}
