package com.kafka.controller;

import com.kafka.kafka.KafkaProducer;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/v2")
public class KafkaController {
    private KafkaProducer kafkaProducer;

    public KafkaController(KafkaProducer kafkaProducer) {
        this.kafkaProducer = kafkaProducer;
    }
    //localhost:8080/api/v1/v2/v3?message="helloBaba"
    @GetMapping("/v3")
    public ResponseEntity<String> getMessage(@RequestParam("message") String message){
        kafkaProducer.sendMessage(message);

        return ResponseEntity.ok("message has sent to the topic");
    }
}
