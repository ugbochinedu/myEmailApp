package emailApp.services;

import emailApp.dtos.*;
import emailApp.models.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertSame;


@SpringBootTest
public class UserServiceTest {

    @Autowired
    private UserService userService;

    @Test
    public void userCanRegisterTest(){
        RegisterUserRequest userRegisterRequest = new RegisterUserRequest();
        userRegisterRequest.setFirstName("chinedu");
        userRegisterRequest.setLastName("ugbo");
        userRegisterRequest.setPassword("amaiyi");
        userRegisterRequest.setEmailAddress("uyyaaaa");
        userRegisterRequest.setPhoneNumber("07035137163");

        RegisterUserResponse registerResponse = userService.registerUser(userRegisterRequest);
        assertNotNull(registerResponse);
        assertNotNull(registerResponse.getMessage());
    }

    @Test
    public void userCanLoginTest(){
        RegisterUserRequest userRegisterRequest = new RegisterUserRequest();
        userRegisterRequest.setFirstName("chinedu");
        userRegisterRequest.setLastName("ugbo");
        userRegisterRequest.setPassword("amaiyi");
        userRegisterRequest.setEmailAddress("uyyaaaa");
        userRegisterRequest.setPhoneNumber("07035137163");
        userRegisterRequest.setDateOfBirth(LocalDate.ofEpochDay(1 / 4 /2023));
        userService.registerUser(userRegisterRequest);
        LoginUserRequest loginUserRequest = new LoginUserRequest();
        loginUserRequest.setEmail("uyyaaaa");
        loginUserRequest.setPassword("amaiyi");
        LoginUserResponse loginUserResponse = userService.login(loginUserRequest);
        assertNotNull(loginUserResponse);
    }

    @Test
    public void updateUserTest(){
        RegisterUserRequest userRegisterRequest = new RegisterUserRequest();
        userRegisterRequest.setFirstName("chinedu");
        userRegisterRequest.setLastName("ugbo");
        userRegisterRequest.setPassword("amaiyi");
        userRegisterRequest.setEmailAddress("uyyaaaa");
        userRegisterRequest.setPhoneNumber("07035137163");
//        userRegisterRequest.setDateOfBirth(LocalDate.ofEpochDay(1 / 4 /2023));
        userService.registerUser(userRegisterRequest);
        UpdateUserRequest updateUserRequest = new UpdateUserRequest();
        updateUserRequest.setFirstName("chime");
        User user = new User();
        assertSame("chime", user.getFirstName());
    }
}
