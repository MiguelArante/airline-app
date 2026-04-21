package com.project.arante.airlineproject;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.project.arante.airlineproject.model.Flight;
import com.project.arante.airlineproject.modelwrapper.FlightWrapper;
import com.project.arante.airlineproject.services.AirlabsService;
import com.project.arante.airlineproject.services.AirlabsServiceImpl;

@ExtendWith(MockitoExtension.class)
@SpringBootTest
class AirlineprojectApplicationTests {

	@Mock
	RestTemplate restTemplate;

	@InjectMocks
	AirlabsServiceImpl airlabsService;

	@Test
	void testFlightIsReturnedTotheList(){
		// Sample Flight Data
		Flight flight = new Flight("999", "MNL", "PR", "MNL","", "", "null", "null");
		
		//Create a wrapper that contains the list of flights
		FlightWrapper wrapper = new FlightWrapper();
		List<Flight> list = List.of(flight);
		wrapper.setResponse(list);

		// Simulate ResposneEntity that returns the wrapper
		ResponseEntity<FlightWrapper> response = new ResponseEntity<>(wrapper, HttpStatus.OK);

		//Mock the method
		when(restTemplate.getForEntity(anyString(), eq(FlightWrapper.class))).thenReturn(response);

		List<Flight> result = airlabsService.searchFlight("MNL");
		assertEquals(1, result.size());
	}

}
