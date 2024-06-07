package com.hotelbookingsystem.model;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "service_consumptions")
public class ServiceConsumption {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_service_consumption")
    private int idServiceConsumption;
    @ManyToOne
    @JoinColumn(name = "id_booking", nullable = false)
    private Booking booking;
    @ManyToOne
    @JoinColumn(name = "id_service", nullable = false)
    private Service service;
    @OneToMany(mappedBy = "serviceConsumption")
    private List<Payment> payments;
    @Column(name = "amount_service_consumption", nullable = false)
    private int amountServiceConsumption;
    @Column(name = "price_service_consumption", nullable = false)
    private Double priceServiceConsumption;
    @Column(name = "date_service_consumption", nullable = false)
    private LocalDateTime dateServiceConsumption;

    public int getIdServiceConsumption() {
        return idServiceConsumption;
    }

    public void setIdServiceConsumption(int idServiceConsumption) {
        this.idServiceConsumption = idServiceConsumption;
    }

    public Booking getBooking() {
        return booking;
    }

    public void setBooking(Booking booking) {
        this.booking = booking;
    }

    public Service getService() {
        return service;
    }

    public void setService(Service service) {
        this.service = service;
    }

    public int getAmountServiceConsumption() {
        return amountServiceConsumption;
    }

    public void setAmountServiceConsumption(int amountServiceConsumption) {
        this.amountServiceConsumption = amountServiceConsumption;
    }

    public Double getPriceServiceConsumption() {
        return priceServiceConsumption;
    }

    public void setPriceServiceConsumption(Double priceServiceConsumption) {
        this.priceServiceConsumption = priceServiceConsumption;
    }

    public LocalDateTime getDateServiceConsumption() {
        return dateServiceConsumption;
    }

    public void setDateServiceConsumption(LocalDateTime dateServiceConsumption) {
        this.dateServiceConsumption = dateServiceConsumption;
    }
}
