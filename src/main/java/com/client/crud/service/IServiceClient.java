package com.client.crud.service;

import com.client.crud.entity.Client;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

public interface IServiceClient {
    ResponseEntity<?> getClients();
    ResponseEntity<?> getClient(Long id);
    ResponseEntity<?> saveOrUpdate(Client client);
    ResponseEntity<?> delete(Long id);
}
