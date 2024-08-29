package com.example.pedido_processor.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.pedido_processor.model.Pedido;

public interface PedidoRepository extends JpaRepository<Pedido, Long> {
    List<Pedido> findByClienteId(Long clienteId);

}
