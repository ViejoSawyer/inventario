package com.alban.gonzalo.inventario.inventario.controller;

import com.alban.gonzalo.inventario.inventario.entity.Store;
import com.alban.gonzalo.inventario.inventario.repository.StoreRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/stores")
public class StoreController {

    private final StoreRepository storeRepository;


    public StoreController(StoreRepository storeRepository) {
        this.storeRepository = storeRepository;
    }

    @GetMapping("/")
    List<Store> all() {
        return storeRepository.findAll();
    }


}
