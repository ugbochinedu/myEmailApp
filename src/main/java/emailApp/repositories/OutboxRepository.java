package emailApp.repositories;

import emailApp.models.Outbox;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface OutboxRepository extends MongoRepository<Outbox, String> {
}
