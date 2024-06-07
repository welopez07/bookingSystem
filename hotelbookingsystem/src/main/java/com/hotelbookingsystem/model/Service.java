package com.hotelbookingsystem.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "services")
public class Service {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_service")
    private int idService;
    @Column(name = "service_name", nullable = false, unique = true)
    private String serviceName;
    @Column(name = "description")
    private String description;
    @Column(name = "service_price")
    private Double servicePrice;
    @OneToMany(mappedBy = "service", cascade = CascadeType.ALL,orphanRemoval = true)
    private List<ServiceConsumption> serviceConsumptions;

    public int getIdService() {
        return idService;
    }

    public void setIdService(int idService) {
        this.idService = idService;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getServicePrice() {
        return servicePrice;
    }

    public void setServicePrice(Double servicePrice) {
        this.servicePrice = servicePrice;
    }

    public List<ServiceConsumption> getServiceConsumptions() {
        return serviceConsumptions;
    }

    public void setServiceConsumptions(List<ServiceConsumption> serviceConsumptions) {
        this.serviceConsumptions = serviceConsumptions;
    }
}
