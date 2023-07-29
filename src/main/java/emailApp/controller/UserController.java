package emailApp.controller;

import emailApp.dtos.LoginUserRequest;
import emailApp.dtos.RegisterUserRequest;
import emailApp.models.User;
import emailApp.services.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("api/v1")
@AllArgsConstructor
public class UserController {
    private UserService userService;

    @PostMapping("/register")
    public Object registerNewUser(@RequestBody RegisterUserRequest registerUserRequest){
        return userService.registerUser(registerUserRequest);
    }

    @PostMapping("/login")
    public Object loginUser(@RequestBody LoginUserRequest loginUserRequest){
        return userService.login(loginUserRequest);
    }

    @GetMapping("/email")
    public  Object findUserByEmail(@RequestBody String email){
        return userService.findUserByEmailAddress(email);
    }

    @GetMapping("/Id")
    public Object findUserById(@RequestBody String Id){
        return userService.findUserById(Id);
    }

}
