package com.alban.gonzalo.inventario.inventario.repository;

import com.alban.gonzalo.inventario.inventario.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {
}
