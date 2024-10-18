package com.pruebaDev.usecase;

import com.pruebaDev.model.Client;
import com.pruebaDev.repository.ClientRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class GetClientUseCase {

    private final ClientRepository clientRepository;

    public GetClientUseCase(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    public Optional<Client> execute(String documentType, String documentNumber) {
        return clientRepository.findClientByDocument(documentType, documentNumber);
    }
}
