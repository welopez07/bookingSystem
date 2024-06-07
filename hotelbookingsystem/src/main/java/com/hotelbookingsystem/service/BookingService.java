package com.hotelbookingsystem.service;

import com.hotelbookingsystem.model.Booking;
import com.hotelbookingsystem.model.Client;
import com.hotelbookingsystem.reposotory.IBookingRepository;
import com.hotelbookingsystem.reposotory.IRoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class BookingService {

    @Autowired
    private IBookingRepository bookingRepository;

    @Autowired
    private IRoomRepository roomRepository;


    public boolean bookingRoomByClient (Client idClient, Integer idRoom, LocalDateTime startDay, LocalDateTime endDay){
        boolean isAvailable = queryAvailableRoom(idRoom, startDay, endDay);
        if (isAvailable){
            //TODO registrar en base de datos la reserva
            Booking booking = new Booking();
            booking.setClient(idClient);
            booking.setRoom(roomRepository.findById(idRoom).orElseThrow());
            booking.setStartDay(startDay);
            booking.setEndDay(endDay);
            bookingRepository.save(booking);
            return true;

        }
        return false;
    }
    //query=consulta

    public boolean queryAvailableRoom(Integer idRoom, LocalDateTime startDate, LocalDateTime endDate){
        //TODO consultar en la base de datos disponibilidad booking
        List<Booking> notAvailableBookings = bookingRepository.findNotAvailableBookings(idRoom, startDate, endDate);
        return notAvailableBookings.isEmpty();
    }

    public List<Booking> getBookingsByClient(Integer idClient){
        return bookingRepository.findByClientId(idClient);
    }


}
