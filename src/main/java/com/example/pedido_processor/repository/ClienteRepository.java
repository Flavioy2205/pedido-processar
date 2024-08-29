package com.example.pedido_processor.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.pedido_processor.model.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
}
