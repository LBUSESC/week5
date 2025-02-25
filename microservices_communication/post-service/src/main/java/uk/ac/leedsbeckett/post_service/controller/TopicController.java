package uk.ac.leedsbeckett.post_service.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uk.ac.leedsbeckett.post_service.entities.Topic;
import uk.ac.leedsbeckett.post_service.services.TopicService;

@RestController
@RequestMapping("/topic")
@RequiredArgsConstructor
public class TopicController {

    private final TopicService topicService;

    @PostMapping("/create")
    public ResponseEntity<Topic> createTopic(@RequestBody Topic topic){

        Topic createdTopic = topicService.creteTopic(topic);
        return new ResponseEntity<>(createdTopic, HttpStatus.CREATED);
    }

    @GetMapping("/{topicId}")
    public ResponseEntity<Topic> getTopicByStudentId(@PathVariable Long topicId){
        Topic topic = topicService.getTopicById(topicId);
        return new ResponseEntity<>(topic, HttpStatus.OK);
    }

}
