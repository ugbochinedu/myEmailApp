package emailApp.AppUtils;

import emailApp.dtos.RegisterUserRequest;
import emailApp.models.User;

public class AppUtil {
    public static User Mapper(RegisterUserRequest registerUserRequest) {
        User user = new User();
        user.setFirstName(registerUserRequest.getFirstName());
        user.setLastName(registerUserRequest.getLastName());
        user.setEmailAddress(registerUserRequest.getEmailAddress());
        user.setPhoneNumber(registerUserRequest.getPhoneNumber());
        user.setPassword(registerUserRequest.getPassword());
        user.setDateOfBirth(registerUserRequest.getDateOfBirth());
        return user;
    }
}
