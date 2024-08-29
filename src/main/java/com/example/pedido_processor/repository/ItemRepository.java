package com.example.pedido_processor.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.pedido_processor.model.Item;

public interface ItemRepository extends JpaRepository<Item, Long> {
}
