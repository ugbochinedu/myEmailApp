package emailApp.AppUtils;

import emailApp.dtos.RegisterUserRequest;
import emailApp.dtos.UpdateUserRequest;
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

    public static User updateUserMapper(User foundUser, UpdateUserRequest updateUserRequest) {
        System.out.println(foundUser);
        if(updateUserRequest.getFirstName() != null) foundUser.setFirstName(updateUserRequest.getFirstName());
        if(updateUserRequest.getLastName() != null) foundUser.setLastName(updateUserRequest.getLastName());
        if(updateUserRequest.getPhoneNumber() != null) foundUser.setPhoneNumber(updateUserRequest.getPhoneNumber());
        if(updateUserRequest.getNewEmailAddress() != null) foundUser.setLastName(updateUserRequest.getNewEmailAddress());
        if(updateUserRequest.getNewPassword() != null) foundUser.setPassword(updateUserRequest.getNewPassword());
        if(updateUserRequest.getDateOfBirth() != null) foundUser.setDateOfBirth(updateUserRequest.getDateOfBirth());

        return foundUser;
    }
}
