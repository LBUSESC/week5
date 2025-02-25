package uk.ac.leedsbeckett.post_service.services;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;
import uk.ac.leedsbeckett.post_service.dto.Student;
import uk.ac.leedsbeckett.post_service.entities.Topic;
import uk.ac.leedsbeckett.post_service.repositories.TopicRepository;

import java.util.Objects;

@Service
@RequiredArgsConstructor
@Slf4j
public class TopicServiceImpl implements TopicService {

    private final TopicRepository topicRepository;
    private final RestClient restClient;
    private final RestTemplate restTemplate;

    String url = "http://localhost:8082/student";


    @Override
    public Topic creteTopic(Topic topic) {

        validateStudent(topic.getStudentId());
        return topicRepository.save(topic);
    }

    @Override
    public Topic getTopicById(Long topicId) {
        Topic topic = topicRepository.findById(topicId).get();
        return topic;
    }

    //RestTemplate implementation.

    private void validateStudent(Long studentIdbyTopic) {
     try {
        ResponseEntity<Student> student = restTemplate.getForEntity(url + "/" + studentIdbyTopic, Student.class);

        if (student.getStatusCode().is2xxSuccessful()) {

            if (Objects.isNull(student)) {
                throw new IllegalArgumentException("Topic cannot be creted with invalid student id" + studentIdbyTopic);
            } else
                log.info("student found with id " + studentIdbyTopic);
        }
     }
    catch (RestClientException e){
        throw new IllegalArgumentException("Topic cannot be creted with invalid student id" + studentIdbyTopic);
      }
    }


    // RestClient Implementation

//    private void validateStudent(Long studentIdbyTopic) {
//
//        try {
//            Student student = restClient.get()
//                    .uri(url + "/" + studentIdbyTopic)
//                    .retrieve()
//                    .body(Student.class);
//
//            if (Objects.isNull(student)) {
//                throw new IllegalArgumentException("Topic cannot be creted with invalid student id" + studentIdbyTopic);
//            } else
//                log.info("student found with id " + studentIdbyTopic);
//        } catch (RestClientException e) {
//            throw new IllegalArgumentException("Topic cannot be retrieved with invalid student id" + studentIdbyTopic);
//        }
//    }
}


