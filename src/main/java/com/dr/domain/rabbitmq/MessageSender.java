package com.dr.domain.rabbitmq;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;

/**
 * come from
 * http://blog.csdn.net/boonya/article/details/37879739
 */
public class MessageSender {


    public static void main(String[] args) throws IOException
    {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost(RabbitLocalConfig.HOST);
        factory.setUsername(RabbitLocalConfig.USER_NAME);
        factory.setPassword(RabbitLocalConfig.USER_PASSWORD);

        Connection connection = factory.newConnection();
        Channel channel = connection.createChannel();

        channel.queueDeclare(RabbitLocalConfig.QUEUE_NAME, false, false, false, null);

        String message = "Hello RabbitMQ! My first message! ";
        channel.basicPublish("", RabbitLocalConfig.QUEUE_NAME, null, message.getBytes());

        System.out.println(" [x] Sent '" + message + "'");

        channel.close();
        connection.close();
    }

}
