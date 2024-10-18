package com.pruebaDev.repository;

import com.pruebaDev.model.Client;

import java.util.Optional;

public interface ClientRepository {

    Optional<Client> findClientByDocument(String documentType, String documentNumber);
}
