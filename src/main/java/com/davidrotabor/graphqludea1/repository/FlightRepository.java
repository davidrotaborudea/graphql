package com.davidrotabor.graphqludea1.repository;

import com.davidrotabor.graphqludea1.entity.Flight;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FlightRepository extends JpaRepository<Flight, Long> {
}
