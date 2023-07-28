package emailApp.repositories;

import emailApp.models.Inbox;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface InboxRepository extends MongoRepository<Inbox, String> {
}
