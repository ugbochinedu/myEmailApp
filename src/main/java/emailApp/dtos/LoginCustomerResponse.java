package emailApp.dtos;

import lombok.Data;

@Data
public class LoginCustomerResponse {
    private String firstName;
    private String lastName;
    private String message;
}
