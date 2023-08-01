package emailApp.controller;

import emailApp.dtos.LoginCustomerRequest;
import emailApp.dtos.RegisterCustomerRequest;
import emailApp.dtos.UpdateCustomerRequest;
import emailApp.dtos.UpdateCustomerResponse;
import emailApp.services.CustomerService;
import lombok.AllArgsConstructor;
import org.springframework.boot.autoconfigure.batch.BatchDataSource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("api/v1")
@AllArgsConstructor
public class CustomerController {
    private CustomerService customerService;

    @PostMapping("/register")
    public Object registerNewCustomer(@RequestBody RegisterCustomerRequest registerCustomerRequest){
        return customerService.registerCustomer(registerCustomerRequest);
    }

    @PostMapping("/login")
    public Object loginCustomer(@RequestBody LoginCustomerRequest loginCustomerRequest){
        return customerService.login(loginCustomerRequest);
    }

    @GetMapping("/email")
    public  Object findCustomerByEmail(@RequestBody String email){
        return customerService.findCustomerByEmailAddress(email);
    }

    @GetMapping("/Id")
    public Object findCustomerById(@RequestBody String Id){
        return customerService.findCustomerById(Id);
    }

    @DeleteMapping("/deleteById{id}")
    public void deleteCustomerById(@PathVariable String id){
        customerService.deleteCustomerById(id);
    }

    @DeleteMapping("/deleteByEmail{email}")
    public void deleteCustomerByEmail(@PathVariable String email){
        customerService.deleteCustomerByEmail(email);
    }

    @PutMapping("/updateCustomer")
    public UpdateCustomerResponse updateCustomer(@RequestBody UpdateCustomerRequest updateCustomerRequest){
        return customerService.updateCustomer(updateCustomerRequest);
    }
}
