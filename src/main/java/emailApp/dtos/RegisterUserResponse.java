package emailApp.dtos;

import lombok.Data;

@Data
public class RegisterUserResponse {
    private String message;
    private String emailAddress;
}
