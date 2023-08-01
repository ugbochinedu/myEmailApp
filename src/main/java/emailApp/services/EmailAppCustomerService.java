package emailApp.services;

import emailApp.AppUtils.AppUtil;
import emailApp.dtos.*;
import emailApp.models.Customer;
import emailApp.models.Message;
import emailApp.repositories.CustomerRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@AllArgsConstructor
@Service
@Slf4j
public class EmailAppCustomerService implements CustomerService {

    private final CustomerRepository customerRepository;
    @Override
    public RegisterCustomerResponse registerCustomer(RegisterCustomerRequest registerCustomerRequest) {
        Customer mappedCustomer = AppUtil.Mapper(registerCustomerRequest);
        Customer savedCustomer = customerRepository.save(mappedCustomer);
        String phoneNumberResponse = MockService.sendToken(savedCustomer.getPhoneNumber());
        log.info("Email sending response->{}",phoneNumberResponse);

        return customerResponse(savedCustomer);
    }

    private RegisterCustomerResponse customerResponse(Customer savedCustomer) {
        RegisterCustomerResponse registerCustomerResponse = new RegisterCustomerResponse();
        registerCustomerResponse.setEmailAddress(savedCustomer.getEmailAddress());
        registerCustomerResponse.setMessage("You have successfully registered your new Email");

        return registerCustomerResponse;
    }

    @Override
    public LoginCustomerResponse login(LoginCustomerRequest loginCustomerRequest) {
        String email = loginCustomerRequest.getEmail();
        String password = loginCustomerRequest.getPassword();

        return getLoginCustomerResponse(email, password);
    }
    private LoginCustomerResponse getLoginCustomerResponse(String email, String password) {
        Customer foundCustomer = findCustomerByEmailAddress(email);
        LoginCustomerResponse loginCustomerResponse = new LoginCustomerResponse();

        if(Objects.equals(foundCustomer.getPassword(), password)){
            loginCustomerResponse.setFirstName(foundCustomer.getFirstName());
            loginCustomerResponse.setLastName(foundCustomer.getLastName());
            loginCustomerResponse.setMessage("You have successfully logged in");
        }
        return loginCustomerResponse;
    }

    public Customer findCustomerByEmailAddress(String email){
        return customerRepository.findUserByEmailAddress(email).orElseThrow(()-> new IllegalArgumentException("Customer not found"));
    }

    public Customer findCustomerById(String Id){
        return customerRepository.findById(Id).orElseThrow(()-> new IllegalArgumentException("Customer not found"));
    }

    @Override
    public void deleteCustomerById(String Id) {
        customerRepository.deleteById(Id);
    }

    public void deleteCustomerByEmail(String email){
        Customer foundCustomer = findCustomerByEmailAddress(email);
        customerRepository.delete(foundCustomer);
    }

    @Override
    public UpdateCustomerResponse updateCustomer(UpdateCustomerRequest updateCustomerRequest) {
        Customer foundCustomer = findCustomerByEmailAddress(updateCustomerRequest.getEmailAddress());
        Customer updatedCustomer = AppUtil.updateCustomerMapper(foundCustomer, updateCustomerRequest);
        customerRepository.save(updatedCustomer);

        return updatedCustomerResponse(foundCustomer);
    }

    private UpdateCustomerResponse updatedCustomerResponse(Customer updatedCustomer) {
        UpdateCustomerResponse updateCustomerResponse = new UpdateCustomerResponse();
        updateCustomerResponse.setDateOfBirth(updatedCustomer.getDateOfBirth());
        updateCustomerResponse.setPhoneNumber(updateCustomerResponse.getPhoneNumber());
        updateCustomerResponse.setEmailAddress(updateCustomerResponse.getEmailAddress());
        updateCustomerResponse.setFirstName(updateCustomerResponse.getFirstName());
        updateCustomerResponse.setLastName(updateCustomerResponse.getLastName());

        return updateCustomerResponse;
    }

    public String createMessage (SendMessageRequest sendMessageRequest){
        Message mappedMessage = AppUtil.messageMapper(sendMessageRequest);
        Customer customer = new Customer();
        customer.saveOutboxMessage(mappedMessage);
        sendMessage(sendMessageRequest,mappedMessage);

        return sendMessageResponse();
    }

    private String sendMessageResponse() {
        SendMessageResponse sendMessageResponse = new SendMessageResponse();
        sendMessageResponse.setMessage("Message successfully sent");

        return sendMessageResponse.getMessage();
    }

    @Override
    public void sendMessage(SendMessageRequest sendMessageRequest, Message mappedMessage) {
        Customer foundCustomer = findCustomerByEmailAddress(sendMessageRequest.getRecipient());
        foundCustomer.saveInboxMessage(mappedMessage);
    }

//    @Override
//    public List<Message> checkReceivedMessage() {
//       return
//    }
}
