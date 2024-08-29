package com.example.pedido_processor.service;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.pedido_processor.dto.PedidoMessage;
import com.example.pedido_processor.model.Cliente;
import com.example.pedido_processor.model.Item; 
import com.example.pedido_processor.model.Pedido;
import com.example.pedido_processor.repository.ClienteRepository;



@Service
public class PedidoConsumerService {

    @Autowired
    private ClienteRepository clienteRepository;


    @Transactional
    @RabbitListener(queues = "pedidoQueue")
    public void consumeMessage(PedidoMessage pedidoMessage) {
        Cliente cliente = clienteRepository.findById((long) pedidoMessage.getCodigoCliente())
                                           .orElse(new Cliente());

        Pedido pedido = new Pedido();
        pedido.setCodigoPedido(pedidoMessage.getCodigoPedido());
        pedido.setCliente(cliente);

        double valorTotal = 0;

        for (PedidoMessage.ItemMessage itemMessage : pedidoMessage.getItens()) {
            Item item = new Item();
            item.setProduto(itemMessage.getProduto());
            item.setQuantidade(itemMessage.getQuantidade());
            item.setPreco(itemMessage.getPreco());
            

            valorTotal += itemMessage.getQuantidade() * itemMessage.getPreco();
            pedido.getItens().add(item); 
        }

        pedido.setValorTotal(valorTotal);
        cliente.getPedidos().add(pedido);

        clienteRepository.save(cliente);

        
    }


}
