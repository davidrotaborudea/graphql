package com.davidrotabor.graphqludea1.service;

import com.davidrotabor.graphqludea1.entity.Flight;
import com.davidrotabor.graphqludea1.entity.Reservation;
import com.davidrotabor.graphqludea1.repository.FlightRepository;
import com.davidrotabor.graphqludea1.repository.ReservationRepository;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class ReservationService {

    private final ReservationRepository reservationRepository;
    private final FlightRepository flightRepository;

    public ReservationService(ReservationRepository reservationRepository, FlightRepository flightRepository) {
        this.reservationRepository = reservationRepository;
        this.flightRepository = flightRepository;
    }

    public Reservation reserveFlight(Long flightId, String passengerName, String seatNumber) {
        Flight flight = flightRepository.findById(flightId).orElseThrow(() -> new IllegalArgumentException("Flight not found"));
        if (flight.getSeatsAvailable() > 0) {
            flight.setSeatsAvailable(flight.getSeatsAvailable() - 1);

            Reservation reservation = new Reservation();
            reservation.setFlight(flight);
            reservation.setPassengerName(passengerName);
            reservation.setSeatNumber(seatNumber);

            String reservationCode = generateReservationCode(flight.getFlightNumber());
            reservation.setReservationCode(reservationCode);
            return reservationRepository.save(reservation);
        }
        else {
            throw new RuntimeException("No seats available");
        }
    }

    private String generateReservationCode(String flightNumber) {
        return flightNumber + "-" + UUID.randomUUID().toString().substring(0, 8).toUpperCase();
    }

}
