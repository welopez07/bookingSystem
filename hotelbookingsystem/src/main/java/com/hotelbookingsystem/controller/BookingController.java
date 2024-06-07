package com.hotelbookingsystem.controller;

import com.hotelbookingsystem.model.Booking;
import com.hotelbookingsystem.model.Client;
import com.hotelbookingsystem.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/bookings")
public class BookingController {

    @Autowired
    private BookingService bookingService;

    @PostMapping("/bookRoom")
    public boolean bookRoom(
            @RequestParam Integer idClient,
            @RequestParam Integer idRoom,
            @RequestParam LocalDateTime starDay,
            @RequestParam LocalDateTime endDay){

        Client client = new Client();
        client.setId(idClient);

        return bookingService.bookingRoomByClient(client,idRoom, starDay, endDay);
    }

    @GetMapping("/availability")
    public boolean checkAvailability(
            @RequestParam Integer idRoom,
            @RequestParam LocalDateTime startDay,
            @RequestParam LocalDateTime endDay){

       return bookingService.queryAvailableRoom(idRoom, startDay,endDay);
    }

    @GetMapping("/cliente/{idClient}")
    public List<Booking> getBookingsByClient(@PathVariable Integer idCliente){
        return bookingService.getBookingsByClient(idCliente);
    }



}
