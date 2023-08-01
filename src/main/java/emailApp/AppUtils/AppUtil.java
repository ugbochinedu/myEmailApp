package emailApp.AppUtils;

import emailApp.dtos.RegisterCustomerRequest;
import emailApp.dtos.SendMessageRequest;
import emailApp.dtos.UpdateCustomerRequest;
import emailApp.models.Customer;
import emailApp.models.Message;

public class AppUtil {
    public static Customer Mapper(RegisterCustomerRequest registerCustomerRequest) {
        Customer customer = new Customer();
        customer.setFirstName(registerCustomerRequest.getFirstName());
        customer.setLastName(registerCustomerRequest.getLastName());
        customer.setEmailAddress(registerCustomerRequest.getEmailAddress());
        customer.setPhoneNumber(registerCustomerRequest.getPhoneNumber());
        customer.setPassword(registerCustomerRequest.getPassword());
        customer.setDateOfBirth(registerCustomerRequest.getDateOfBirth());
        return customer;
    }

    public static Customer updateCustomerMapper(Customer foundCustomer, UpdateCustomerRequest updateCustomerRequest) {
        if(updateCustomerRequest.getFirstName() != null) foundCustomer.setFirstName(updateCustomerRequest.getFirstName());
        if(updateCustomerRequest.getLastName() != null) foundCustomer.setLastName(updateCustomerRequest.getLastName());
        if(updateCustomerRequest.getPhoneNumber() != null) foundCustomer.setPhoneNumber(updateCustomerRequest.getPhoneNumber());
        if(updateCustomerRequest.getNewEmailAddress() != null) foundCustomer.setLastName(updateCustomerRequest.getNewEmailAddress());
        if(updateCustomerRequest.getNewPassword() != null) foundCustomer.setPassword(updateCustomerRequest.getNewPassword());
        if(updateCustomerRequest.getDateOfBirth() != null) foundCustomer.setDateOfBirth(updateCustomerRequest.getDateOfBirth());

        return foundCustomer;
    }

    public static Message messageMapper(SendMessageRequest sendMessageRequest) {
        Message message = new Message();
        message.setSubject(sendMessageRequest.getSubject());
        message.setSender(sendMessageRequest.getSender());
        message.setRecipient(sendMessageRequest.getRecipient());
        message.setBody(sendMessageRequest.getBody());
        message.setTimeStamp(sendMessageRequest.getTimeStamp());
        return message;
    }
}
