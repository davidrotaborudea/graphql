package com.davidrotabor.graphqludea1.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "reservation")
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idReservation;
    private String passengerName;
    private String seatNumber;
    private String reservationCode;

    @ManyToOne
    @JoinColumn(name = "flight_id")
    private Flight flight;

}
