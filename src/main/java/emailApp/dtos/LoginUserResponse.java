package emailApp.dtos;

import lombok.Data;

@Data
public class LoginUserResponse {
    private String firstName;
    private String lastName;
    private String message;
}
