package com.project.arante.airlineproject.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.project.arante.airlineproject.services.AirlabsService;

/**
 * Page Controller for Airline View
 */
@Controller
public class AirlineController {

    private AirlabsService airlabsService;

    public AirlineController(AirlabsService airlabsService){
        this.airlabsService = airlabsService;
    }
    
    @GetMapping("/airlines")
    public String airlinesPage(Model model) {
       model.addAttribute("airlines", this.airlabsService.viewAirlines());
        return "airlines";
    }
    

}
