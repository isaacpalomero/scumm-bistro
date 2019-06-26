package com.scumm.micros.category;

import com.rabbitmq.client.BuiltinExchangeType;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@PropertySource("classpath:application.properties")
public class CategoryBrokerBcCreator implements CommandLineRunner {

    @Value("${message.rabbitmq.server}")
    private String rabbitServer;

    @Override
    public void run(String... args) throws Exception {

        ConnectionFactory connectionFactory = new ConnectionFactory();
        connectionFactory.setUri(this.rabbitServer);
        Connection connection = connectionFactory.newConnection();
        Channel channel = connection.createChannel();
        channel.exchangeDeclare("Scumm", BuiltinExchangeType.TOPIC , true, false, null);
        channel.exchangeDeclare("Category", BuiltinExchangeType.TOPIC , true, false, null);
        channel.exchangeBind("Category", "Scumm", "Category.#");
        channel.close();
        connection.close();
    }
}
