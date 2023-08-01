package emailApp.repositories;

import emailApp.models.Customer;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface CustomerRepository extends MongoRepository<Customer, String>{
    Optional<Customer> findUserByEmailAddress(String email);
}
