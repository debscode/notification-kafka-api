package com.debscode.notificationkafkaapi.controller;

import com.debscode.notificationkafkaapi.constant.Kafka;
import com.debscode.notificationkafkaapi.dto.Notification;
import com.debscode.notificationkafkaapi.service.NotificationProducerService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/notifications")
@RequiredArgsConstructor
public class NotificationController {

    private final NotificationProducerService notificationProducerService;

    @PostMapping
    public Notification sendNotification(@RequestBody Notification notification){
        return notificationProducerService.sendNotification(Kafka.TOPIC_NAME, notification);
    }
}
