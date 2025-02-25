package uk.ac.leedsbeckett.post_service.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import uk.ac.leedsbeckett.post_service.entities.Topic;

public interface TopicRepository extends MongoRepository<Topic, Long> {
}
