package com.alban.gonzalo.inventario.inventario.service;

import com.alban.gonzalo.inventario.inventario.entity.Store;
import com.alban.gonzalo.inventario.inventario.repository.ProductRepository;
import com.alban.gonzalo.inventario.inventario.repository.ProductStoreRepository;
import com.alban.gonzalo.inventario.inventario.repository.StoreRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class StoreServiceImpl implements StoreService{

    private final StoreRepository storeRepository;

    private ProductRepository productRepository;

    private ProductStoreRepository productStoreRepository;

    public StoreServiceImpl(StoreRepository storeRepository) {
        this.storeRepository = storeRepository;
    }

    @Transactional
    @Override
    public void chargeStores(List<Store> stores) {
        storeRepository.saveAll(stores);
    }

}
