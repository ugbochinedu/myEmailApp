package emailApp.dtos;

import lombok.Data;
import java.time.LocalDate;
@Data
public class UpdateUserRequest {
    private String firstName;
    private String lastName;
    private String password;
    private String emailAddress;
    private String newEmailAddress;
    private String newPassword;
    private String phoneNumber;
    private LocalDate dateOfBirth;
}
