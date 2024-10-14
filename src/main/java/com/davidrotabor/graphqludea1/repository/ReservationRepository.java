package com.davidrotabor.graphqludea1.repository;

import com.davidrotabor.graphqludea1.entity.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation, Long> {
}
