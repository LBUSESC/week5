package com.sesc.unistudycircle.topic_service.controllers;

import com.sesc.unistudycircle.topic_service.entities.Topic;
import com.sesc.unistudycircle.topic_service.services.TopicServiceImpl;

import org.junit.jupiter.api.Test;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

class TopicControllerTest {
    @Mock
    private TopicServiceImpl topicService;

    @InjectMocks
    private TopicController topicController;

    private Topic topic;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        topic = new Topic(123l, "SESC", "2025-03-25", "sesc course", 899l, "John");
    }

    @Test
    void postTopic() {
        when(topicService.postTopic(any(Topic.class))).thenReturn(topic);

        ResponseEntity<Topic> response = topicController.postTopic(topic);

        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertEquals(topic, response.getBody());
    }

    @Test
    void viewTopic() {
        when(topicService.viewTopic(1L)).thenReturn(topic);

        ResponseEntity<Topic> response = topicController.viewTopic(1L);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(topic, response.getBody());
    }

    @Test
    void updateTopic() {
        when(topicService.updateTopic(eq(1L), any(Topic.class))).thenReturn(topic);

        ResponseEntity<Topic> response = topicController.updateTopic(1L, topic);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(topic, response.getBody());
    }

    @Test
    void deleteTopic() {
        doNothing().when(topicService).deleteTopic(1L);

        ResponseEntity<Void> response = topicController.deleteTopic(1L);

        assertEquals(HttpStatus.NO_CONTENT, response.getStatusCode());
    }
}