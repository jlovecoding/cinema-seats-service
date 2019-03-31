package com.cinema.seats.controller;

import com.cinema.seats.model.Seat;
import com.cinema.seats.repository.SeatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.List;

import static org.springframework.format.annotation.DateTimeFormat.ISO.DATE_TIME;

@RestController
@RequestMapping("/seats")
public class SeatController {

    @Autowired
    private SeatRepository seatRepository;

    @GetMapping
    public List<Seat> findByScreenAndStartAndAvailable(
            @RequestParam final Integer screen,
            @RequestParam @DateTimeFormat(iso = DATE_TIME) final LocalDateTime start,
            @RequestParam final Boolean available) {
        return seatRepository.findByScreenAndStartAndAvailable(screen, start, available);
    }
}
