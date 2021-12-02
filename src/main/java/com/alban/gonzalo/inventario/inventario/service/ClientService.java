package com.alban.gonzalo.inventario.inventario.service;

import com.alban.gonzalo.inventario.inventario.entity.Client;
import org.springframework.http.ResponseEntity;

public interface ClientService {

    ResponseEntity<?> save(Client newClient);

    ResponseEntity<?> update(Client newClient, Long id);
}
