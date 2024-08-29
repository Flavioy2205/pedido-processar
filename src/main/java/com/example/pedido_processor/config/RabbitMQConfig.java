package com.example.pedido_processor.config;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {

    @Bean
    public Queue pedidoQueue() {
        return new Queue("pedidoQueue", false);
    }
}