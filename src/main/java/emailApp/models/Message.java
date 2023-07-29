package emailApp.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;


@Data
@AllArgsConstructor
@NoArgsConstructor

public class Message {
    private String id;
    private User sender;
    private User recipient;
    private String subject;
    private String body;
    private LocalDateTime timeStamp;
}
