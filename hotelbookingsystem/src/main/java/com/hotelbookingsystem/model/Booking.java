package com.hotelbookingsystem.model;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
@Entity
@Table(name = "bookings")
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_booking")
    private int idBooking;
    @Column(name = "start_day", nullable = false)
    private LocalDateTime startDay;
    @Column(name = "end_day", nullable = false)
    private LocalDateTime endDay;
    @Column(name = "number_of_people")
    private int numberOfPeople;
    @Column(name = "status")
    private String status;
    @ManyToOne
    @JoinColumn(name = "client_id", nullable = false)
    private Client client;

    @ManyToOne
    @JoinColumn(name = "id_room", nullable = false)
    private Room room;
    @OneToMany(mappedBy = "booking", cascade = CascadeType.ALL)
    private List<ServiceConsumption> serviceConsumptions;

    public int getIdBooking() {
        return idBooking;
    }

    public void setIdBooking(int idBooking) {
        this.idBooking = idBooking;
    }

    public LocalDateTime getStartDay() {
        return startDay;
    }

    public void setStartDay(LocalDateTime startDay) {
        this.startDay = startDay;
    }

    public LocalDateTime getEndDay() {
        return endDay;
    }

    public void setEndDay(LocalDateTime endDay) {
        this.endDay = endDay;
    }

    public int getNumberOfPeople() {
        return numberOfPeople;
    }

    public void setNumberOfPeople(int numberOfPeople) {
        this.numberOfPeople = numberOfPeople;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public List<ServiceConsumption> getServiceConsumptions() {
        return serviceConsumptions;
    }

    public void setServiceConsumptions(List<ServiceConsumption> serviceConsumptions) {
        this.serviceConsumptions = serviceConsumptions;
    }
}
