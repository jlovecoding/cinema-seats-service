package com.cinema.seats.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SeatId implements Serializable {
    private Integer screen;
    private LocalDateTime start;
    private Integer seatNumber;
}
