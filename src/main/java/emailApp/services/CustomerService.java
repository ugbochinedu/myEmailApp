package emailApp.services;

import emailApp.dtos.*;
import emailApp.models.Customer;

public interface CustomerService {
    RegisterCustomerResponse registerCustomer(RegisterCustomerRequest registerCustomerRequest);
    LoginCustomerResponse login (LoginCustomerRequest loginCustomerRequest);
    UpdateCustomerResponse updateCustomer(UpdateCustomerRequest updateCustomerRequest);
    Customer findCustomerByEmailAddress(String email);
    Customer findCustomerById(String Id);

    void deleteCustomerById(String Id);

    void deleteCustomerByEmail(String Id);
    String createMessage(SendMessageRequest sendMessageRequest);
    void sendMessage(SendMessageRequest sendMessageRequest);
}
