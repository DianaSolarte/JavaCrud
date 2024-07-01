package com.client.crud.controller;

import com.client.crud.entity.Client;
import com.client.crud.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path= "api/v1/clients")

public class ClientController {

    private final ClientService clientService;

    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @GetMapping
    public ResponseEntity<?> getAll(){
        return clientService.getClients();
    }

    @GetMapping("/{clientId}")
    public ResponseEntity<?> getById(@PathVariable("clientId") Long clientId){
        return clientService.getClient(clientId);
    }

    @PostMapping
    public ResponseEntity<?> saveUpdate(@RequestBody Client client){
        return clientService.saveOrUpdate(client);
    }

    @DeleteMapping("/{clientId}")
    public ResponseEntity<?> saveUpdate(@PathVariable("clientId") Long clientId) {
        return clientService.delete(clientId);
    }

}
