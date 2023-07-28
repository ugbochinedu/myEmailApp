package emailApp.models;

import lombok.Data;

import java.util.List;

@Data
public class Inbox {
    private List<Message> receivedMessages;
}
