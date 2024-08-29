package com.example.pedido_processor.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.pedido_processor.model.Pedido;
import com.example.pedido_processor.repository.PedidoRepository;

@Service
public class PedidoService {

    @Autowired
    private PedidoRepository pedidoRepository;

    public double calcularValorTotal(Long pedidoId) {
        Pedido pedido = pedidoRepository.findById(pedidoId).orElseThrow(() -> new RuntimeException("Pedido não encontrado"));
        return pedido.getValorTotal();
    }

    public long contarPedidosPorCliente(Long clienteId) {
        return pedidoRepository.findByClienteId(clienteId).size();
    }

   
    public List<Pedido> listarPedidosPorCliente(Long clienteId) {
        return pedidoRepository.findByClienteId(clienteId);
    }
}