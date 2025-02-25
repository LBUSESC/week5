package uk.ac.leedsbeckett.post_service.services;

import uk.ac.leedsbeckett.post_service.entities.Topic;

public interface TopicService {

    public Topic creteTopic(Topic topic);
    public Topic getTopicById(Long topicId);
}
