package br.com.workana.configs;

import org.springframework.amqp.core.*;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {

    private final AmqpAdmin amqpAdmin;
    @Value("${spring.rabbitmq.queue}")
    private String queue;

    @Bean
    public Queue queue() {
        return new Queue(queue, true);
    }

    @Bean
    public Jackson2JsonMessageConverter messageConverter() {
        return new Jackson2JsonMessageConverter();
    }

    private static final String EXCHANGE = "amq.topic";

    public RabbitMQConfig(AmqpAdmin amqpAdmin){
        this.amqpAdmin = amqpAdmin;
    }

    private Queue criarFila(String nome){
        return new Queue(nome);
    }

    private TopicExchange criarTopicExchange(String nome){
        return new TopicExchange(nome, true, false);
    }

    private Binding binding(TopicExchange topicExchange, Queue queue){
        return BindingBuilder.bind(queue).to(topicExchange).with(queue.getName());
    }

    private void adicionar(String nomeFila){
        TopicExchange exchange = criarTopicExchange(EXCHANGE);
        Queue fila = criarFila(nomeFila);

        Binding binding = binding(exchange, fila);

        amqpAdmin.declareExchange(exchange);
        amqpAdmin.declareQueue(fila);
        amqpAdmin.declareBinding(binding);
    }
}
