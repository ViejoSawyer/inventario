package com.alban.gonzalo.inventario.inventario.service;

import com.alban.gonzalo.inventario.inventario.entity.Client;
import com.alban.gonzalo.inventario.inventario.repository.ClientRepository;
import com.alban.gonzalo.inventario.inventario.util.CustomErrorType;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class ClientServiceImpl implements ClientService {

    private ClientRepository clientRepository;

    public ClientServiceImpl(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }


    @Override
    public ResponseEntity<?> save(Client newClient) {
        if (validateNameDocument(newClient)) {
            return new ResponseEntity<Client>(clientRepository.save(newClient), HttpStatus.OK);
        }
        return new ResponseEntity(new CustomErrorType("El nombre y la identificacion son obligatorios"), HttpStatus.BAD_REQUEST);
    }

    @Override
    public ResponseEntity<?> update(Client newClient, Long id) {
        return clientRepository.findById(id)
                .map(cli -> {
                    if (validateNameDocument(newClient)) {
                        cli.setName(newClient.getName().trim());
                        cli.setDocument(newClient.getDocument().trim());
                        return new ResponseEntity<Client>(clientRepository.save(cli), HttpStatus.OK);
                    }
                    return new ResponseEntity(new CustomErrorType("El nombre y la identificacion son obligatorios"), HttpStatus.BAD_REQUEST);
                }).orElse(new ResponseEntity(new CustomErrorType("Cliente con código " + id + " no encontrado"), HttpStatus.BAD_REQUEST));
    }

    private boolean validateNameDocument(Client client) {
        return client.getName() != null && !client.getName().trim().isEmpty()
                && client.getDocument() != null && !client.getDocument().trim().isEmpty() ? true : false;
    }
}
