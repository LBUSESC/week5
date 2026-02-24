package com.unistudycircle.topic_service.services;

import com.unistudycircle.topic_service.entities.Topic;
import com.unistudycircle.topic_service.repositories.TopicRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class TopicService {

    private final TopicRepository repository;

    public TopicService(TopicRepository repository) {
        this.repository = repository;
    }


    public Topic postTopic(Topic topic) {
        return repository.save(topic);
    }


    public Topic viewTopic(Long topicId) {
        return repository.findById(topicId)
                .orElseThrow(() -> new RuntimeException("Topic not found with ID: " + topicId));
    }


    public Topic updateTopic(Long topicId, Topic updatedTopic) {
        Topic existingTopic = repository.findById(topicId)
                .orElseThrow(() -> new RuntimeException("Topic not found with ID: " + topicId));

        existingTopic.setTopicName(updatedTopic.getTopicName());
        existingTopic.setTopicDate(updatedTopic.getTopicDate());
        existingTopic.setTopicContent(updatedTopic.getTopicContent());
        existingTopic.setStudentId(updatedTopic.getStudentId());
        existingTopic.setStudentName(updatedTopic.getStudentName());
        return repository.save(existingTopic);
    }


    public void deleteTopic(Long topicId) {
        if (!repository.existsById(topicId)) {
            throw new RuntimeException("Topic not found with ID: " + topicId);
        }
        repository.deleteById(topicId);
    }


    public List<Topic> searchAllTopicByStudentId(Long studentId) {
        return repository.findAllByStudentId(studentId);
    }


    public List<Topic> searchAllTopicByStudentName(String studentName) {
        return repository.findAllByStudentName(studentName);
    }


    public Topic searchTopicByTopicId(Long topicId) {
        return repository.findById(topicId)
                .orElseThrow(() -> new RuntimeException("Topic not found with ID: " + topicId));
    }


    public List<Topic> searchTopicByDate(LocalDate topicDate) {
        return repository.findAllByTopicDate(topicDate);
    }
}
