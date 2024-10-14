package com.davidrotabor.graphqludea1.resolver;


import com.davidrotabor.graphqludea1.entity.Flight;
import com.davidrotabor.graphqludea1.service.FlightService;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.time.LocalDateTime;
import java.util.List;

@Controller
public class FlightController {

    private final FlightService flightService;

    public FlightController(FlightService flightService) {
        this.flightService = flightService;
    }

    @QueryMapping
    private List<Flight> allFlights() {
        return flightService.getAllFlights();
    }

    @QueryMapping
    private Flight flightById(@Argument Long idFlight) {
        return flightService.getFlightById(idFlight
        );
    }

    @MutationMapping
    private Flight addFlight(@Argument String flightNumber, @Argument int seatsAvailable, @Argument String origin, @Argument String destination, @Argument String departureTime, @Argument String arrivalTime) {
        LocalDateTime departure = LocalDateTime.parse(departureTime);
        LocalDateTime arrival = LocalDateTime.parse(arrivalTime);

        return flightService.addFligh(flightNumber, seatsAvailable, origin, destination, departure, arrival);
    }

}
