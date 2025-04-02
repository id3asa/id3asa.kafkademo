package main.java.com.github.id3asa.kafkademo.controller;

import java.lang.ModuleLayer.Controller;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RequestMapping ("/api/kafka")
@RestController
public class RestController {

    final KafkaTemplate kafkaTemplate;


    Logger logger = LoggerFactory.getLogger(Controller.class);

    public Controller(KafkaTemplate kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    @PostMapping
    public String sentMessage(@RequestBody Hurricane hurricane) {
        this.kafkaTemplate.send("hurricane-ian", new Hurricane(hurricane));

        return "Hurricane information sent to Kafka.";
    }

    @KafkaListener(topics = "hurricane-ian")
    public void listener(@Payload Hurricane hurricane,  ConsumerRecord consumerRecord) {
        logger.info("Topic [hurricane-ian] Received message from {} with {} PLN ", hurricane.name, hurricane.categoryAtLandfall, hurricane.centralPressureAtLandfall, hurricane.dateOfLandfall, hurricane.estimatedDamage, hurricane.fatalities, hurricane.maximumSustainedWinds, hurricane.notes);
        logger.info(consumerRecord.toString());
    }


}