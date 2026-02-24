package com.unistudycircle.topic_service.services;

import com.unistudycircle.topic_service.client.StudentClient;
import com.unistudycircle.topic_service.dtos.StudentInfo;
import com.unistudycircle.topic_service.entities.Topic;
import com.unistudycircle.topic_service.repositories.TopicRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;
@Slf4j
@Service
public class TopicService {

    private final TopicRepository repository;

    private final StudentClient studentClient;

    public TopicService(TopicRepository repository, StudentClient studentClient) {
        this.repository = repository;
        this.studentClient = studentClient;
    }


    public Topic postTopic(Topic topic) {
        validateStudent(topic.getStudentId());
        return repository.save(topic);
    }

    private void validateStudent(Long studentId) {
        if(studentId == null) {
            throw new IllegalArgumentException("Student id is required");
        }

        ResponseEntity<StudentInfo> studentInfo = studentClient.getStudent(studentId);
        if(Objects.isNull(studentInfo.getBody())) {
            throw new IllegalArgumentException("Student id is invalid");
        }
        log.info("Available student: {}", studentInfo);
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
