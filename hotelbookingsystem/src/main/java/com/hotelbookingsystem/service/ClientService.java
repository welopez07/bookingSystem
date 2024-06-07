package com.hotelbookingsystem.service;

import com.hotelbookingsystem.model.Client;
import com.hotelbookingsystem.reposotory.IClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ClientService {

    private IClientRepository iClientRepository;

    public Optional<Client> getClientById(Integer id){
        return iClientRepository.findById(id);
    }
}
