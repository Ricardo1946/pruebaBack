package com.pruebaDev.repository;

import com.pruebaDev.model.Client;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Repository
public class InMemoryClientRepository implements  ClientRepository{

    private final Map<String, Client> clientDatabase = new HashMap<>();

    public InMemoryClientRepository() {
        clientDatabase.put("C123456", new Client("John", "Michael", "Doe", "Smith", "1234567890", "123 Main St", "New York"));
        clientDatabase.put("P987654", new Client("Jane", "Maria", "Doe", "Johnson", "0987654321", "456 Broad St", "Los Angeles"));
    }

    @Override
    public Optional<Client> findClientByDocument(String documentType, String documentNumber) {
        return Optional.ofNullable(clientDatabase.get(documentType + documentNumber));
    }
}
