package com.project.arante.airlineproject.modelwrapper;

import java.util.List;

import com.project.arante.airlineproject.model.Airline;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class AirlineWrapper {
    
    private List<Airline> response;
}
