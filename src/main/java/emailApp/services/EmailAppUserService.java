package emailApp.services;

import emailApp.AppUtils.AppUtil;
import emailApp.dtos.*;
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

    private final UserRepository userRepository;
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
        User foundUser = findUserByEmailAddress(email);
        LoginUserResponse loginUserResponse = new LoginUserResponse();

        if(Objects.equals(foundUser.getPassword(), password)){
            loginUserResponse.setFirstName(foundUser.getFirstName());
            loginUserResponse.setLastName(foundUser.getLastName());
            loginUserResponse.setMessage("You have successfully logged in");
        }
//        userRepository.delete(foundUser);
        return loginUserResponse;
    }

    public User findUserByEmailAddress(String email){
        return userRepository.findUserByEmailAddress(email);
    }

    public User findUserById(String Id){
        return userRepository.findById(Id).orElseThrow(()-> new IllegalArgumentException("User not found"));
    }

    @Override
    public void deleteUserById(String Id) {
        userRepository.deleteById(Id);
    }

    public void deleteUser(User user){
        userRepository.delete(user);
    }

    @Override
    public UpdateUserResponse updateUser(UpdateUserRequest updateUserRequest) {
        User foundUser = findUserByEmailAddress(updateUserRequest.getEmailAddress());
        User updatedUser = AppUtil.updateUserMapper(foundUser,updateUserRequest);
        System.out.println(updatedUser);
        userRepository.save(updatedUser);

        return updatedUserResponse(updatedUser);
    }

    private UpdateUserResponse updatedUserResponse(User updatedUser) {
        UpdateUserResponse updateUserResponse = new UpdateUserResponse();
        updateUserResponse.setDateOfBirth(updatedUser.getDateOfBirth());
        updateUserResponse.setPhoneNumber(updateUserResponse.getPhoneNumber());
        updateUserResponse.setEmailAddress(updateUserResponse.getEmailAddress());
        updateUserResponse.setFirstName(updateUserResponse.getFirstName());
        updateUserResponse.setLastName(updateUserResponse.getLastName());

        return updateUserResponse;
    }


}
