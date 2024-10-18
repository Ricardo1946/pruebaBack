package com.pruebaDev.Controller;

import com.pruebaDev.model.Client;
import com.pruebaDev.usecase.GetClientUseCase;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.junit.jupiter.api.BeforeEach;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class ClientControllerTest {
    @Mock
    private GetClientUseCase getClientUseCase;

    @InjectMocks
    private ClientController clientController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void shouldReturnClientInfo_whenValidRequest() {
        String documentType = "C";
        String documentNumber = "23445322";

        Client mockClient = new Client("Juan", "Jose", "Diaz", "Gonzales", "1234567890", "calle 80 a # 26 - 23", "Bogotá");
        when(getClientUseCase.execute(documentType, documentNumber)).thenReturn(Optional.of(mockClient));
        ResponseEntity<?> response = clientController.getClientInfo(documentType, documentNumber);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(mockClient, response.getBody());
    }

    @Test
    void shouldReturnNotFound_whenClientDoesNotExist() {
        String documentType = "C";
        String documentNumber = "12345678";

        when(getClientUseCase.execute(documentType, documentNumber)).thenReturn(Optional.empty());
        ResponseEntity<?> response = clientController.getClientInfo(documentType, documentNumber);
        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
        assertEquals("Client not found", response.getBody());
    }

    @Test
    void shouldReturnBadRequest_whenInvalidDocumentType() {
        ResponseEntity<?> response = clientController.getClientInfo("X", "23445322");
        assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
        assertEquals("Invalid document type. It must be 'C' or 'P'.", response.getBody());
    }

}