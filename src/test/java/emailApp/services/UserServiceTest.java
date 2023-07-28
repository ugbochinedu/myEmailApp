package emailApp.services;

import emailApp.dtos.LoginUserRequest;
import emailApp.dtos.LoginUserResponse;
import emailApp.dtos.RegisterUserRequest;
import emailApp.dtos.RegisterUserResponse;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.assertNotNull;


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
        userService.registerUser(userRegisterRequest);
        LoginUserRequest loginUserRequest = new LoginUserRequest();
        loginUserRequest.setEmail("uyyaaaa");
        loginUserRequest.setPassword("amaiyi");
        LoginUserResponse loginUserResponse = userService.login(loginUserRequest);
        assertNotNull(loginUserResponse);
    }
}
