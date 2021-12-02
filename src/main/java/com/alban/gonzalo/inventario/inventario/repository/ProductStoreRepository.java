package com.alban.gonzalo.inventario.inventario.repository;

import com.alban.gonzalo.inventario.inventario.entity.ProductStore;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductStoreRepository extends JpaRepository<ProductStore, Long> {
}
