package com.hotelbookingsystem.service;

import com.hotelbookingsystem.model.Booking;
import com.hotelbookingsystem.model.Client;
import com.hotelbookingsystem.reposotory.IBookingRepository;
import com.hotelbookingsystem.reposotory.IClientRepository;
import com.hotelbookingsystem.reposotory.IRoomRepository;
import com.hotelbookingsystem.utils.DateTimeUtils;
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
    @Autowired
    private IClientRepository clientRepository;


    public boolean bookingRoomByClient (Integer idClient, Integer idRoom, LocalDateTime startDay, LocalDateTime endDay){
        Client client = clientRepository.findById(idClient).orElseThrow(() -> new IllegalArgumentException("Cliente no encontrado"));
        boolean isAvailable = queryAvailableRoom(idRoom, startDay, endDay);
        if (isAvailable){
            //TODO registrar en base de datos la reserva
            Booking booking = new Booking();
            booking.setClient(client);
            booking.setRoom(roomRepository.findById(idRoom).orElseThrow());
            booking.setStartDay(startDay);
            booking.setEndDay(endDay);
            bookingRepository.save(booking);
            return true;

        }
        return false;
    }
    //query=consulta
    public String formatBookingDetails(LocalDateTime startDay, LocalDateTime endDay){
        String formattedStartDay = startDay.format(DateTimeUtils.DATE_FORMATTER);
        String formattedStartTime = startDay.format(DateTimeUtils.TIME_FORMATTER);
        String formattedEndDay = endDay.format(DateTimeUtils.DATE_FORMATTER);
        String formattedEndTime = endDay.format(DateTimeUtils.TIME_FORMATTER);

        return String.format("Fecha de reserva: %s ingreso a las %s, salida el %s a las %s",
                formattedStartDay, formattedStartTime, formattedEndDay, formattedEndTime);

    }

    public boolean queryAvailableRoom(Integer idRoom, LocalDateTime startDate, LocalDateTime endDate){
        //TODO consultar en la base de datos disponibilidad booking
        List<Booking> notAvailableBookings = bookingRepository.findNotAvailableBookings(idRoom, startDate, endDate);
        return notAvailableBookings.isEmpty();
    }

    public List<Booking> getBookingsByClient(Integer idClient){
        return bookingRepository.findByClientId(idClient);
    }


}
