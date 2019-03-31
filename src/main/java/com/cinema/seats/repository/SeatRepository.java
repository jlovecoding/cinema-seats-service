package com.cinema.seats.repository;


import com.cinema.seats.model.Seat;
import com.cinema.seats.model.SeatId;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface SeatRepository extends JpaRepository<Seat, SeatId> {
    List<Seat> findByScreenAndStartAndAvailable(Integer screen, LocalDateTime start, Boolean available);
}
