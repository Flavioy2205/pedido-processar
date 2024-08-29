package com.example.pedido_processor.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.pedido_processor.model.Pedido;
import com.example.pedido_processor.service.PedidoService;

@RestController
@RequestMapping("/api")
public class PedidoController {

    @Autowired
    private PedidoService pedidoService;

    @GetMapping("/{pedidoId}/valor-total")
    public double getValorTotal(@PathVariable Long pedidoId) {
        return pedidoService.calcularValorTotal(pedidoId);
    }

    @GetMapping("/cliente/{clienteId}/quantidade")
    public long getQuantidadePedidosPorCliente(@PathVariable Long clienteId) {
        return pedidoService.contarPedidosPorCliente(clienteId);
    }

    @GetMapping("/cliente/{clienteId}")
    public List<Pedido> getPedidosPorCliente(@PathVariable Long clienteId) {
        return pedidoService.listarPedidosPorCliente(clienteId);
    }
}
