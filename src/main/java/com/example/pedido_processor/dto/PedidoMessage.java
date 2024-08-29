package com.example.pedido_processor.dto;

import java.util.List;

public class PedidoMessage {
    private int codigoPedido;
    private int codigoCliente;
    private List<ItemMessage> itens;

    // Getters e Setters
    public int getCodigoPedido() {
        return codigoPedido;
    }

    public void setCodigoPedido(int codigoPedido) {
        this.codigoPedido = codigoPedido;
    }

    public int getCodigoCliente() {
        return codigoCliente;
    }

    public void setCodigoCliente(int codigoCliente) {
        this.codigoCliente = codigoCliente;
    }

    public List<ItemMessage> getItens() {
        return itens;
    }

    public void setItens(List<ItemMessage> itens) {
        this.itens = itens;
    }

    // Classe ItemMessage
    public static class ItemMessage {
        private String produto;
        private int quantidade;
        private double preco;

        // Getters e Setters
        public String getProduto() {
            return produto;
        }

        public void setProduto(String produto) {
            this.produto = produto;
        }

        public int getQuantidade() {
            return quantidade;
        }

        public void setQuantidade(int quantidade) {
            this.quantidade = quantidade;
        }

        public double getPreco() {
            return preco;
        }

        public void setPreco(double preco) {
            this.preco = preco;
        }
    }
}