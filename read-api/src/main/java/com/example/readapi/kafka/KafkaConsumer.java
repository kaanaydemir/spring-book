package com.example.readapi.kafka;

import com.example.readapi.dtos.KafkaReadDto;
import com.example.readapi.service.KafkaService;
import com.google.gson.Gson;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumer {
    private final Logger logger = LoggerFactory.getLogger(KafkaConsumer.class);
    private final KafkaService kafkaService;

    public KafkaConsumer(KafkaService kafkaService) {
        this.kafkaService = kafkaService;
    }

    @KafkaListener(topics = "user-readlist",groupId = "readlist-group",containerFactory = "kafkaListenerContainerFactory")
    void listener(ConsumerRecord<String,String> consumerRecord) {
        String key = consumerRecord.key();
        String value = consumerRecord.value();
        kafkaService.consume(value);
        logger.info("Kafka message received for key : {} value : {}", key, value);
    }
}
