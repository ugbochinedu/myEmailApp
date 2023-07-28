package emailApp.services;

import emailApp.dtos.LoginUserRequest;
import emailApp.dtos.LoginUserResponse;
import emailApp.dtos.RegisterUserRequest;
import emailApp.dtos.RegisterUserResponse;

public interface UserService {
    RegisterUserResponse registerUser(RegisterUserRequest registerUserRequest);
    LoginUserResponse login (LoginUserRequest loginUserRequest);
}
