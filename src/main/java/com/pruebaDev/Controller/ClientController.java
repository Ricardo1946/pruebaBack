package com.pruebaDev.Controller;

import com.pruebaDev.model.Client;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/api/clients")
public class ClientController {

    @GetMapping("/info")
    public ResponseEntity<?> getClientInfo(
            @RequestParam String documentType,
            @RequestParam String documentNumber) {

        // Validate document type
        if (!documentType.equals("C") && !documentType.equals("P")) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("Invalid document type. It must be 'C' or 'P'.");
        }

        if (documentType.equals("C") && documentNumber.equals("23445322")) {
            Client client = new Client(
                    "Juan",
                    "Jose",
                    "Diaz",
                    "Gonzales",
                    "1234567890",
                    "calle 80 a # 26 - 23",
                    "Bogotá"
            );
            return new ResponseEntity<>(client, HttpStatus.OK);
        }

        return new ResponseEntity<>("Client not found", HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleGeneralErrors(Exception e) {
        return new ResponseEntity<>("Internal server error: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
