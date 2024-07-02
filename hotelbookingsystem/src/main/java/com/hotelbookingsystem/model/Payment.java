package com.hotelbookingsystem.model;


import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.Date;
@Entity
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idPayment;
    @Column(name = "payment_date", nullable = false)
    private LocalDateTime paymentDate;
    @Column(name = "payment_amount", nullable = false)
    private Double paymentAmount;
    @Column(name = "payment_method", nullable = false)
    private String paymentMethod;
    @ManyToOne
    @JoinColumn(name = "id_booking")
    private Booking booking;
    @ManyToOne
    @JoinColumn(name = "id_service_consumption")
    private ServiceConsumption serviceConsumption;
    @ManyToOne
    @JoinColumn(name = "id_client")
    private Client client;

    public int getIdPayment() {
        return idPayment;
    }

    public void setIdPayment(int idPayment) {
        this.idPayment = idPayment;
    }

    public LocalDateTime getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(LocalDateTime paymentDate) {
        this.paymentDate = paymentDate;
    }

    public Double getPaymentAmount() {
        return paymentAmount;
    }

    public void setPaymentAmount(Double paymentAmount) {
        this.paymentAmount = paymentAmount;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public Booking getBooking() {
        return booking;
    }

    public void setBooking(Booking booking) {
        this.booking = booking;
    }

    public ServiceConsumption getServiceConsumption() {
        return serviceConsumption;
    }

    public void setServiceConsumption(ServiceConsumption serviceConsumption) {
        this.serviceConsumption = serviceConsumption;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }
}
