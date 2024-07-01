package com.client.crud.service;

import com.client.crud.entity.Client;
import com.client.crud.repository.ClientRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientService implements IServiceClient {

    private final ClientRepository clientRepository;

    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    public ResponseEntity<?> getClients(){
        List<Client> clients = clientRepository.findAll();
        if(clients.isEmpty()){
            return new ResponseEntity<>("No se encuentran Clientes", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(clients, HttpStatus.OK);
    }

    public ResponseEntity<?> getClient(Long id){
        Optional<Client> client = clientRepository.findById(id);
        if(client.isEmpty()){
            return new ResponseEntity<>("No se encuentra el Cliente: " + id, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(client, HttpStatus.OK);

    }

    public ResponseEntity<?> saveOrUpdate(Client client){
        Client cliente = clientRepository.findByEmail(client.getEmail()).orElse(null);
        if(cliente != null){
            return new ResponseEntity<>("Este correo electrónico ya existe en la base de datos: " + client.getEmail(), HttpStatus.NOT_FOUND);
        }
        clientRepository.save(client);
        return new ResponseEntity<>("El correo electrónico se guardo exitosamente", HttpStatus.OK);
    }

    public ResponseEntity<?> delete(Long id){
        Client client = clientRepository.findById(id).orElse(null);
        if(client == null){
            return new ResponseEntity<>("No existe el usuario seleccionado", HttpStatus.NOT_FOUND);
        }

        clientRepository.deleteById(id);
        return new ResponseEntity<>("Se elimino exitosamente el usuario: "+ client.getName(), HttpStatus.OK);

    }
}
