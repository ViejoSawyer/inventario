package com.alban.gonzalo.inventario.inventario.repository;

import com.alban.gonzalo.inventario.inventario.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
}
