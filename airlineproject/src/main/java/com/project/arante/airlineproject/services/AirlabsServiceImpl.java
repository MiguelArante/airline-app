package com.project.arante.airlineproject.services;

import java.util.Collections;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.project.arante.airlineproject.model.Airline;
import com.project.arante.airlineproject.model.Airport;
import com.project.arante.airlineproject.model.Flight;
import com.project.arante.airlineproject.modelwrapper.AirlineWrapper;
import com.project.arante.airlineproject.modelwrapper.AirportWrapper;
import com.project.arante.airlineproject.modelwrapper.FlightWrapper;

/**
 * Implementaion of AirLabService
 */
@Service
public class AirlabsServiceImpl implements AirlabsService{

    private static final String URL = "https://airlabs.co/api/v9/";
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Value("${API_KEY}")
    public String API_KEY;

    private RestTemplate restTemplate;

    public AirlabsServiceImpl(RestTemplate restTemplate){
        this.restTemplate = restTemplate;
    }

    /**
     * View Airlines
     * This calls the /airlines endpoint from AirLabs API 
     */
    @Override
    public List<Airline> viewAirlines() {
        this.logger.info("### Begin ViewAirlines ");
        UriComponentsBuilder uri = UriComponentsBuilder
            .fromUriString(URL)
            .path("airlines")
            .queryParam("api_key", API_KEY);

        ResponseEntity<AirlineWrapper> response = this.restTemplate.getForEntity(uri.toUriString(), AirlineWrapper.class);   
        AirlineWrapper wrapper = response.getBody();
        return wrapper != null ? wrapper.getResponse() : Collections.emptyList();  
    }

    /**
     * View Airports
     * This calls the /airports endpoint from AirLabs API
     */
    @Override
    public List<Airport> viewAirports() {
       this.logger.info("### Begin viewAirports");
       UriComponentsBuilder uri = UriComponentsBuilder
            .fromUriString(URL)
            .path("airports")
            .queryParam("api_key", API_KEY);

        ResponseEntity<AirportWrapper> response = this.restTemplate.getForEntity(uri.toUriString(), AirportWrapper.class);   
        AirportWrapper wrapper = response.getBody();
        return wrapper != null ? wrapper.getResponse() : Collections.emptyList();
    }

    /**
     * Search Flights based on dep_iata
     * This calls the /flight endpoint from AirLabs API
     */
    @Override
    public List<Flight> searchFlight(String dep_iata) {
        this.logger.info("### Begin SearchFlight " + dep_iata);
        UriComponentsBuilder uri = UriComponentsBuilder
            .fromUriString(URL)
            .path("flights")
            .queryParam("api_key", API_KEY)
            .queryParam("dep_iata", dep_iata);

        ResponseEntity<FlightWrapper> response = this.restTemplate.getForEntity(uri.toUriString(), FlightWrapper.class);   
        FlightWrapper wrapper = response.getBody();
        return wrapper != null ? wrapper.getResponse() : Collections.emptyList();
    }

    
}
