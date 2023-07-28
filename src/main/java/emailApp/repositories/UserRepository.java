package emailApp.repositories;

import emailApp.models.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, String>{
//    User findUsersByEmailAddress(String email);
    User findUserByEmailAddress(String email);
}
