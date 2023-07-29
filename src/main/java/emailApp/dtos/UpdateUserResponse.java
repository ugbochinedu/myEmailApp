package emailApp.dtos;

import lombok.Data;
import java.time.LocalDate;
@Data
public class UpdateUserResponse {
    private String firstName;
    private String lastName;
    private String emailAddress;
    private String phoneNumber;
    private LocalDate dateOfBirth;
}
