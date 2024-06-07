package com.hotelbookingsystem.reposotory;

import com.hotelbookingsystem.model.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface IBookingRepository extends JpaRepository<Booking, Integer> {

    @Query("SELECT b FROM Booking b WHERE b.room.id = :roomId AND " +
            "(b.startDay <= :endDate AND b.endDay >= :startDate)")
    List<Booking> findNotAvailableBookings(@Param("roomId") Integer roomId,
                                           @Param("startDate") LocalDateTime startDate,
                                           @Param("endDate") LocalDateTime endDate);

    List<Booking> findByClientId(Integer idClient);

}
