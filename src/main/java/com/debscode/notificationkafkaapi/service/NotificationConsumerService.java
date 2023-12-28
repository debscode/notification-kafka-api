package com.debscode.notificationkafkaapi.service;

import com.debscode.notificationkafkaapi.constant.Kafka;
import com.debscode.notificationkafkaapi.dto.Notification;
import lombok.extern.java.Log;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@Log
public class NotificationConsumerService {
    private final Logger logger = LoggerFactory.getLogger(NotificationConsumerService.class);

    @KafkaListener(topics = {Kafka.TOPIC_NAME}, groupId = Kafka.GROUP_NAME)
    public void consume(Notification notification) {
        logger.info("Notification status is updated : " + notification.getStatus());
    }
}
