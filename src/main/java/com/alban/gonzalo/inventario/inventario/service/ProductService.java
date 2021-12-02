package com.alban.gonzalo.inventario.inventario.service;

import com.alban.gonzalo.inventario.inventario.entity.Product;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.http.ResponseEntity;

public interface ProductService {

    void save() throws JsonProcessingException;

    ResponseEntity<?> update(Product newProduct, Long id);

}
