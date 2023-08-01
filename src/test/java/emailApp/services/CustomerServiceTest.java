package emailApp.services;

import emailApp.dtos.*;
import emailApp.models.Customer;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
public class CustomerServiceTest {

    @Autowired
    private CustomerService customerService;

    @Test
    public void customerCanRegisterTest(){
        RegisterCustomerRequest customerRegisterRequest = new RegisterCustomerRequest();
        customerRegisterRequest.setFirstName("chinedu");
        customerRegisterRequest.setLastName("ugbo");
        customerRegisterRequest.setPassword("amaiyi");
        customerRegisterRequest.setEmailAddress("uyyaaaa");
        customerRegisterRequest.setPhoneNumber("07035137163");
        customerRegisterRequest.setDateOfBirth(LocalDate.of(1989,1,20));

        RegisterCustomerResponse registerResponse = customerService.registerCustomer(customerRegisterRequest);
        assertNotNull(registerResponse);
        assertNotNull(registerResponse.getMessage());
    }

    @Test
    public void userCanLoginTest(){
        RegisterCustomerRequest customerRegisterRequest = new RegisterCustomerRequest();
        customerRegisterRequest.setFirstName("chinedu");
        customerRegisterRequest.setLastName("ugbo");
        customerRegisterRequest.setPassword("amaiyi");
        customerRegisterRequest.setEmailAddress("uyyaaaa");
        customerRegisterRequest.setPhoneNumber("07035137163");
        customerRegisterRequest.setDateOfBirth(LocalDate.of(1948,4,23));
        customerService.registerCustomer(customerRegisterRequest);
        LoginCustomerRequest loginCustomerRequest = new LoginCustomerRequest();
        loginCustomerRequest.setEmail("uyyaaaa");
        loginCustomerRequest.setPassword("amaiyi");
        LoginCustomerResponse loginCustomerResponse = customerService.login(loginCustomerRequest);
        assertNotNull(loginCustomerResponse);
    }

    @Test
    public void updateUserTest(){
        RegisterCustomerRequest customerRegisterRequest = new RegisterCustomerRequest();
        customerRegisterRequest.setFirstName("chinedu");
        customerRegisterRequest.setLastName("ugbo");
        customerRegisterRequest.setPassword("amaiyi");
        customerRegisterRequest.setEmailAddress("uyyaaaa");
        customerRegisterRequest.setPhoneNumber("07035137163");
        customerRegisterRequest.setDateOfBirth(LocalDate.of(1989,1,20));
        customerService.registerCustomer(customerRegisterRequest);
        UpdateCustomerRequest updateCustomerRequest = new UpdateCustomerRequest();
        updateCustomerRequest.setFirstName("chime");
        updateCustomerRequest.setEmailAddress("uyyaaaa");
        customerService.updateCustomer(updateCustomerRequest);
        System.out.println(updateCustomerRequest);
        assertEquals("chime", updateCustomerRequest.getFirstName());
    }

    @Test
    public void customerCanSaveMessageTest(){
        SendMessageRequest sendMessageRequest = new SendMessageRequest();
        sendMessageRequest.setSubject("Title");
        sendMessageRequest.setBody("Hi I am here");
        sendMessageRequest.setRecipient("o.ugbo@yahoo.com");
        sendMessageRequest.setSender("o.chine@yahoo.com");
        sendMessageRequest.setTimeStamp(LocalDateTime.now());
        Customer customer = new Customer();
        customerService.createMessage(sendMessageRequest);
        assertNotNull(customer.getSavedOutboxMessage());
    }
}
