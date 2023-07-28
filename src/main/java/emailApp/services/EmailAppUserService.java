package emailApp.services;

import emailApp.AppUtils.AppUtil;
import emailApp.dtos.LoginUserRequest;
import emailApp.dtos.LoginUserResponse;
import emailApp.dtos.RegisterUserRequest;
import emailApp.dtos.RegisterUserResponse;
import emailApp.models.User;
import emailApp.repositories.UserRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Objects;

@AllArgsConstructor
@Service
@Slf4j
public class EmailAppUserService implements UserService{

    private UserRepository userRepository;
    @Override
    public RegisterUserResponse registerUser(RegisterUserRequest registerUserRequest) {
        User mappedUser = AppUtil.Mapper(registerUserRequest);
        User savedUser = userRepository.save(mappedUser);
        String phoneNumberResponse = MockService.sendToken(savedUser.getPhoneNumber());
        log.info("Email sending response->{}",phoneNumberResponse);


        return userResponse(savedUser);
    }

    private RegisterUserResponse userResponse(User savedUser) {
        RegisterUserResponse registerUserResponse = new RegisterUserResponse();
        registerUserResponse.setEmailAddress(savedUser.getEmailAddress());
        registerUserResponse.setMessage("You have successfully registered your new Email");

        return registerUserResponse;
    }

    @Override
    public LoginUserResponse login(LoginUserRequest loginUserRequest) {
        String email = loginUserRequest.getEmail();
        String password = loginUserRequest.getPassword();

        return getLoginUserResponse(email, password);
    }

    private LoginUserResponse getLoginUserResponse(String email, String password) {
        User foundUser = userRepository.findUserByEmailAddress(email);
        LoginUserResponse loginUserResponse = new LoginUserResponse();

        if(Objects.equals(foundUser.getPassword(), password)){
            loginUserResponse.setFirstName(foundUser.getFirstName());
            loginUserResponse.setLastName(foundUser.getLastName());
            loginUserResponse.setMessage("You have successfully logged in");
        }
        return loginUserResponse;
    }

}
