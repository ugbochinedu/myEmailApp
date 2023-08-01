package emailApp.models;

import emailApp.dtos.SendMessageRequest;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Customer {
    @Id
    private String id;
    private String firstName;
    private String lastName;
    private String password;
    private String emailAddress;
    private String phoneNumber;
    private LocalDate dateOfBirth;
    private List<Message> receivedMessages = new ArrayList<>();
    private List<Message> outBoxMessages = new ArrayList<>();


    public void saveOutboxMessage(Message message){
        outBoxMessages.add(message);
    }

    public List<Message> getSavedOutboxMessage(){
        return outBoxMessages;
    }
    public void saveInboxMessage(Message message){
        receivedMessages.add(message);
    }

    public List<Message> getReceivedInboxMessage(){
        return receivedMessages;
    }
}
