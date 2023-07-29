package emailApp.services;

import emailApp.dtos.*;
import emailApp.models.User;

public interface UserService {
    RegisterUserResponse registerUser(RegisterUserRequest registerUserRequest);
    LoginUserResponse login (LoginUserRequest loginUserRequest);
    UpdateUserResponse updateUser(UpdateUserRequest updateUserRequest);
    User findUserByEmailAddress(String email);
    User findUserById(String Id);
    void deleteUserById(String Id);
    void deleteUser(User user);
}
