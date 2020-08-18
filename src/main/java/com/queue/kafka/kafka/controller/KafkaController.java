package com.queue.kafka.kafka.controller;


import com.queue.kafka.kafka.service.Consumer;
import com.queue.kafka.kafka.service.Producer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/kafka")
public class KafkaController {

    private final Producer producer;
    private final Logger logger = LoggerFactory.getLogger(Consumer.class);

    @Autowired
    public KafkaController(Producer producer) {
        this.producer = producer;
    }

    @PostMapping(value = "/publish")
    public void sendMessageToKafkaTopic(@RequestBody String message) {
        logger.info("incoming message");
        this.producer.sendMessage(message);
    }

}
