package com.hotelbookingsystem.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "clients")
public class Client extends Person {
    @Column(name = "id_cliente")
    private int idCliente;
    @Column(name = "preferences")
    private String preferences;
    @Column(name = "city")
    private String city;
    @Column(name = "country")
    private String country;
    @OneToMany(mappedBy = "client", cascade = CascadeType.ALL)
    private List<Booking> bookings;

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public String getPreferences() {
        return preferences;
    }

    public void setPreferences(String preferences) {
        this.preferences = preferences;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public List<Booking> getBookings() {
        return bookings;
    }

    public void setBookings(List<Booking> bookings) {
        this.bookings = bookings;
    }
}
