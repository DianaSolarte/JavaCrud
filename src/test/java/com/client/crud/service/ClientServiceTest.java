package com.client.crud.service;

import com.client.crud.entity.Client;
import com.client.crud.repository.ClientRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class ClientServiceTest {

    @Mock
    private ClientRepository clientRepository;

    @InjectMocks
    private ClientService clientService;

    private Client client;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
        client = new Client();
        client.setName("Sofia Arroyos");
        client.setEmail("sofiaarroyos@bit.com");
        client.setPhone("3215673499");
        client.setAddress("Calle 123 #12-43");
        client.setCity("Buenos Aires");
    }

    @Test
    void getClients_WhenClientsExist() {
        // Given
        when(clientRepository.findAll()).thenReturn(Collections.singletonList(client));

        // When
        ResponseEntity<?> response = clientService.getClients();

        // Then
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertNotNull(response.getBody());
        List<Client> result = (List<Client>) response.getBody();
        assertFalse(result.isEmpty());
        assertEquals("Sofia Arroyos", result.get(0).getName());
        assertEquals("sofiaarroyos@bit.com", result.get(0).getEmail());
        assertEquals("3215673499", result.get(0).getPhone());
        assertEquals("Calle 123 #12-43", result.get(0).getAddress());
        assertEquals("Buenos Aires", result.get(0).getCity());
    }

    @Test
    void getClients_WhenNoClientsExist() {
        // Given
        when(clientRepository.findAll()).thenReturn(Collections.emptyList());

        // When
        ResponseEntity<?> response = clientService.getClients();

        // Then
        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
        assertEquals("No se encuentran Clientes", response.getBody());
    }

    @Test
    void getClient_WhenClientExists() {
        // Given
        Long clientId = 1L;
        when(clientRepository.findById(clientId)).thenReturn(Optional.of(client));

        // When
        ResponseEntity<?> response = clientService.getClient(clientId);

        // Then
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertNotNull(response.getBody());
        Client result = ((Optional<Client>) response.getBody()).get();
        assertEquals("Sofia Arroyos", result.getName());
        assertEquals("sofiaarroyos@bit.com", result.getEmail());
        assertEquals("3215673499", result.getPhone());
        assertEquals("Calle 123 #12-43", result.getAddress());
        assertEquals("Buenos Aires", result.getCity());
    }

    @Test
    void getClient_WhenClientDoesNotExist() {
        // Given
        Long clientId = 1L;
        when(clientRepository.findById(clientId)).thenReturn(Optional.empty());

        // When
        ResponseEntity<?> response = clientService.getClient(clientId);

        // Then
        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
        assertEquals("No se encuentra el Cliente: " + clientId, response.getBody());
    }

    @Test
    void saveOrUpdate_WhenEmailAlreadyExists() {
        // Given
        when(clientRepository.findByEmail(client.getEmail())).thenReturn(Optional.of(client));

        // When
        ResponseEntity<?> response = clientService.saveOrUpdate(client);

        // Then
        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
        assertEquals("Este correo electrónico ya existe en la base de datos: " + client.getEmail(), response.getBody());
        verify(clientRepository, never()).save(any(Client.class));
    }

    @Test
    void saveOrUpdate_WhenEmailDoesNotExist() {
        // Given
        when(clientRepository.findByEmail(client.getEmail())).thenReturn(Optional.empty());

        // When
        ResponseEntity<?> response = clientService.saveOrUpdate(client);

        // Then
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals("El correo electrónico se guardo exitosamente", response.getBody());
        verify(clientRepository, times(1)).save(client);
    }


    @Test
    void delete_WhenClientExists() {
        // Given
        Long clientId = 1L;
        when(clientRepository.findById(clientId)).thenReturn(Optional.of(client));

        // When
        ResponseEntity<?> response = clientService.delete(clientId);

        // Then
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals("Se elimino exitosamente el usuario: " + client.getName(), response.getBody());
        verify(clientRepository, times(1)).deleteById(clientId);
    }

    @Test
    void delete_WhenClientDoesNotExist() {
        // Given
        Long clientId = 1L;
        when(clientRepository.findById(clientId)).thenReturn(Optional.empty());

        // When
        ResponseEntity<?> response = clientService.delete(clientId);

        // Then
        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
        assertEquals("No existe el usuario seleccionado", response.getBody());
        verify(clientRepository, never()).deleteById(clientId);
    }

}
