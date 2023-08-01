package emailApp.dtos;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class SendMessageRequest {
    private String sender;
    private String recipient;
    private String subject;
    private String body;
    private LocalDateTime timeStamp;
}
