package com.hotelbookingsystem.controller;

import com.hotelbookingsystem.model.Client;
import com.hotelbookingsystem.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/clients")
public class ClientController {
    @Autowired
    private ClientService clientService;

    @GetMapping("/{id}")
    public Optional<Client> getClientById(@PathVariable Integer id){
        return clientService.getClientById(id);
    }


}
