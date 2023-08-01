package emailApp.dtos;

import lombok.Data;

@Data
public class RegisterCustomerResponse {
    private String message;
    private String emailAddress;
}
