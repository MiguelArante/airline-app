package com.project.arante.airlineproject.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.project.arante.airlineproject.services.AirlabsService;

/**
 * Page Controller for Airport View
 */
@Controller
public class AirportController {
    
    private AirlabsService airlabService;

    public AirportController(AirlabsService airlabsService){
        this.airlabService = airlabsService;
    }

    @GetMapping("/airports")
    public String airportPage(Model model) {
        model.addAttribute("airports",this.airlabService.viewAirports());
        return "airports";
    }
    


}
