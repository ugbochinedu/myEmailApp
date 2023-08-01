package emailApp.dtos;

import lombok.Data;

@Data
public class LoginCustomerRequest {
    private String email;
    private String password;
}
