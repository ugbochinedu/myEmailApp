package emailApp.dtos;

import lombok.Data;

@Data
public class LoginUserRequest {
    private String email;
    private String password;
}
