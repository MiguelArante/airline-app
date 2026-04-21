package com.project.arante.airlineproject.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.project.arante.airlineproject.services.AirlabsService;
import org.springframework.web.bind.annotation.RequestParam;


/**
 * Page Controlelr for Flight View
 */
@Controller
public class FlightController {

    private AirlabsService airlabsService;

    public FlightController(AirlabsService airlabsService){
        this.airlabsService = airlabsService;
    }

    @GetMapping("/flights")
    public String getFlights() {
        return "flights";
    }

    @GetMapping("/searchFlight")
    public String searchFlight(@RequestParam String dep_iata, Model model) {
        model.addAttribute("flights",  this.airlabsService.searchFlight(dep_iata));
        return "flights";
    }
    
    
    
}
