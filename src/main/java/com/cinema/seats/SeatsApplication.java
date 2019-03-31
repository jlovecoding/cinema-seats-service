package com.cinema.seats;

import com.cinema.seats.model.Seat;
import com.cinema.seats.repository.SeatRepository;
import io.vavr.Tuple4;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.stream.Stream;

import static io.vavr.Tuple.of;
import static java.time.LocalDateTime.of;

@SpringBootApplication
public class SeatsApplication {

    public static void main(String[] args) {
        SpringApplication.run(SeatsApplication.class, args);
    }

    @Component
    public class SeatsLoader implements CommandLineRunner {

        @Autowired
        private SeatRepository seatRepository;

        @Override
        public void run(String... strings) {
            createSeats().forEach(seatRepository::save);
        }

        private Stream<Seat> createSeats() {
            Stream<Tuple4<Integer, LocalDateTime, Integer, Boolean>> films = Stream.of(
                    of(1, of(2019, 4, 1, 18, 30), 1, true),
                    of(1, of(2019, 4, 1, 18, 30), 2, false),
                    of(1, of(2019, 4, 1, 18, 30), 3, false),
                    of(1, of(2019, 4, 1, 18, 30), 4, false),

                    of(1, of(2019, 4, 1, 21, 0), 1, true),
                    of(1, of(2019, 4, 1, 21, 0), 2, true),
                    of(1, of(2019, 4, 1, 21, 0), 3, false),
                    of(1, of(2019, 4, 1, 21, 0), 4, false),

                    of(2, of(2019, 4, 1, 16, 0), 1, true),
                    of(2, of(2019, 4, 1, 16, 0), 2, true),
                    of(2, of(2019, 4, 1, 16, 0), 3, true),
                    of(2, of(2019, 4, 1, 16, 0), 4, false),

                    of(2, of(2019, 4, 1, 20, 0), 1, true),
                    of(2, of(2019, 4, 1, 20, 0), 2, true),
                    of(2, of(2019, 4, 1, 20, 0), 3, true),
                    of(2, of(2019, 4, 1, 20, 0), 4, true),

                    of(1, of(2019, 4, 2, 18, 30), 1, false),
                    of(1, of(2019, 4, 2, 18, 30), 2, false),
                    of(1, of(2019, 4, 2, 18, 30), 3, false),
                    of(1, of(2019, 4, 2, 18, 30), 4, false),

                    of(5, of(2019, 4, 2, 18, 30), 1, true),
                    of(5, of(2019, 4, 2, 18, 30), 2, false),
                    of(5, of(2019, 4, 2, 18, 30), 3, false),
                    of(5, of(2019, 4, 2, 18, 30), 4, true));

            return films.map(tuple3 -> Seat.builder()
                    .screen(tuple3._1())
                    .start(tuple3._2())
                    .seatNumber(tuple3._3())
                    .available(tuple3._4())
                    .build());
        }
    }
}
