package emailApp.models;

import lombok.*;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Outbox {
    private List<Message> sentMessages;
}
