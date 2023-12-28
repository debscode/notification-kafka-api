package com.debscode.notificationkafkaapi.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Notification {

    private String id;
    private String notificationDetails;
    private Status status;

    public enum Status {
        SUBMITTED,
        STARTED,
        RUNNING,
        FINISHED,
        TERMINATED
    }

}


