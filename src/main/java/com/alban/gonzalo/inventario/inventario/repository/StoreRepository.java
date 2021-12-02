package com.alban.gonzalo.inventario.inventario.repository;

import com.alban.gonzalo.inventario.inventario.entity.Store;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StoreRepository extends JpaRepository<Store, Long> {
}
