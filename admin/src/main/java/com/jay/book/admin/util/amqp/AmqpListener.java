//package com.jay.book.admin.util.amqp;
//
//import org.springframework.amqp.core.Message;
//import org.springframework.amqp.rabbit.annotation.RabbitHandler;
//import org.springframework.amqp.rabbit.annotation.RabbitListener;
//import org.springframework.stereotype.Component;
//
//@Component
//@RabbitListener(queues = "hello")
//public class AmqpListener {
//
//    @RabbitHandler
//    public void process(Message message) {
//        System.out.println("Receiver1  : " + new String(message.getBody()));
//    }
//
//}