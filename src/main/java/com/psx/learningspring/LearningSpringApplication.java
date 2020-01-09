package com.psx.learningspring;

import com.psx.learningspring.data.entity.Guest;
import com.psx.learningspring.data.entity.Reservation;
import com.psx.learningspring.data.entity.Room;
import com.psx.learningspring.data.repository.GuestRepository;
import com.psx.learningspring.data.repository.ReservationRepository;
import com.psx.learningspring.data.repository.RoomRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class LearningSpringApplication {

  public static void main(String[] args) {
    SpringApplication.run(LearningSpringApplication.class, args);
  }

  /**
   * In Production, this type of code is not seen since embedded databases are usually not the most
   * realistic source of data.
   */
  @RestController
  @RequestMapping("/rooms")
  public static class RoomController {
    @Autowired
    private RoomRepository roomRepository;

    @GetMapping
    public Iterable<Room> getRooms() {
      return this.roomRepository.findAll();
    }
  }

  @RestController
  @RequestMapping("/guests")
  public static class GuestController {
    @Autowired
    private GuestRepository guestRepository;

    @GetMapping
    public Iterable<Guest> getGuests() {
      return this.guestRepository.findAll();
    }
  }

  @RestController
  @RequestMapping("/reservations")
  public static class ReservationController {
    @Autowired
    private ReservationRepository reservationRepository;

    @GetMapping
    public Iterable<Reservation> getReservations() {
      return this.reservationRepository.findAll();
    }
  }
}
