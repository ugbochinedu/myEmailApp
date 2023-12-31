package emailApp.dtos;

import lombok.Data;

import java.time.LocalDate;

@Data
public class RegisterCustomerRequest {
    private String firstName;
    private String lastName;
    private String password;
    private String emailAddress;
    private String phoneNumber;
    private LocalDate dateOfBirth;
}
