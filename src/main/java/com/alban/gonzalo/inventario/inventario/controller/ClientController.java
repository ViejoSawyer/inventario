package com.alban.gonzalo.inventario.inventario.controller;

import com.alban.gonzalo.inventario.inventario.entity.Client;
import com.alban.gonzalo.inventario.inventario.repository.ClientRepository;
import com.alban.gonzalo.inventario.inventario.service.ClientService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/clients")
public class ClientController {

    private final ClientRepository clientRepository;
    private final ClientService clientService;

    public ClientController(ClientRepository clientRepository, ClientService clientService) {
        this.clientRepository = clientRepository;
        this.clientService = clientService;
    }

    @GetMapping("/")
    List<Client> all() {
        return clientRepository.findAll();
    }

    @PostMapping("/")
    ResponseEntity<?> newClient(@RequestBody Client newClient) {
        return clientService.save(newClient);
    }

    @PutMapping("/{id}")
    ResponseEntity<?> updateProduct(@RequestBody Client newClient, @PathVariable Long id) {
        return clientService.update(newClient, id);
    }

    @DeleteMapping("/{id}")
    void deleteClient(@PathVariable Long id) {
        clientRepository.deleteById(id);
    }
}
