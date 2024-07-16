package com.hotelbookingsystem.controller;

import com.hotelbookingsystem.dto.BookingRequest;
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
    public String bookRoom(@RequestBody BookingRequest bookingRequest) {
        System.out.println(("Received bookingRequest: " + bookingRequest ));

        Integer idClient = bookingRequest.getIdClient();
        if (idClient == null) {
            throw new IllegalArgumentException("idClient no puede ser nulo");
        }

        boolean bookingSuccess = bookingService.bookingRoomByClient(
                idClient,
                bookingRequest.getIdRoom(),
                bookingRequest.getStartDay(),
                bookingRequest.getEndDay());
        if (bookingSuccess) {
            return bookingService.formatBookingDetails(
                    bookingRequest.getStartDay(),
                    bookingRequest.getEndDay());
        } else {
            return "No se pudo realizar la reserva. La habitación no está disponible en las fechas seleccionadas.";

        }
    }


    @GetMapping("/availability")
    public boolean checkAvailability(
            @RequestParam Integer idRoom,
            @RequestParam LocalDateTime startDay,
            @RequestParam LocalDateTime endDay){

        return bookingService.queryAvailableRoom(idRoom, startDay,endDay);
    }

    @GetMapping("/cliente/{idClient}")
    public List<Booking> getBookingsByClient(@PathVariable Integer idClient){
        return bookingService.getBookingsByClient(idClient);
    }



}
