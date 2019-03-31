package com.cinema.seats.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Entity
@Table(name = "seats")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@IdClass(SeatId.class)
public class Seat {
    @Id
    private Integer screen;
    @Id
    private LocalDateTime start;
    @Id
    private Integer seatNumber;

    private Boolean available;
}
