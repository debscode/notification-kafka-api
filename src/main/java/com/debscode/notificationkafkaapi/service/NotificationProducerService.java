package com.debscode.notificationkafkaapi.service;

import com.debscode.notificationkafkaapi.dto.Notification;
import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@Log
@RequiredArgsConstructor
public class NotificationProducerService {
    private final Logger LOGGER = LoggerFactory.getLogger(NotificationProducerService.class);

    private final KafkaTemplate<String, Notification> kafkaTemplate;

    public Notification sendNotification(String topicName, Notification notification) {

        var future = kafkaTemplate.send(topicName, notification.getId(), notification);

        future.whenComplete((sendResult, exception) -> {
            if (exception != null) {
                future.completeExceptionally(exception);
            } else {
                future.complete(sendResult);
            }
            LOGGER.info("Notification status send to Kafka topic : " + notification.getStatus());
        });

        LOGGER.info(String.valueOf(future));

        return notification;
    }
}
