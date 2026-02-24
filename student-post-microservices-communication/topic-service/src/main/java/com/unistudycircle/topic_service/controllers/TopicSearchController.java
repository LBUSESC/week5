package com.unistudycircle.topic_service.controllers;

import com.unistudycircle.topic_service.entities.Topic;
import com.unistudycircle.topic_service.services.TopicService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("api/v1/search")
@RequiredArgsConstructor
public class TopicSearchController {

    private final TopicService topicService;

    @GetMapping("/studentId/{studentId}")
    public ResponseEntity<List<Topic>> searchAllTopicByStudentId(@PathVariable Long studentId) {
        List<Topic> topics = topicService.searchAllTopicByStudentId(studentId);
        return new ResponseEntity<>(topics, HttpStatus.OK);
    }

    @GetMapping("/studentName/{studentName}")
    public ResponseEntity<List<Topic>> searchAllTopicByStudentName(@PathVariable String studentName) {
        List<Topic> topics = topicService.searchAllTopicByStudentName(studentName);
        return new ResponseEntity<>(topics, HttpStatus.OK);
    }

    @GetMapping("/topicId/{topicId}")
    public ResponseEntity<Topic> searchTopicByTopicId(@PathVariable Long topicId) {
        Topic topic = topicService.searchTopicByTopicId(topicId);
        return new ResponseEntity<>(topic, HttpStatus.OK);
    }

    @GetMapping("/date/{topicDate}")
    public ResponseEntity<List<Topic>> searchTopicByDate(@PathVariable String topicDate) {
        LocalDate date = LocalDate.parse(topicDate);
        List<Topic> topics = topicService.searchTopicByDate(date);
        return new ResponseEntity<>(topics, HttpStatus.OK);
    }
}

