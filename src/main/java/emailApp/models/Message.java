package emailApp.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

import java.time.LocalDateTime;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class Message {
    @Id
    private String id;
    private String sender;
    private String recipient;
    private String subject;
    private String body;
    private LocalDateTime timeStamp;
}
