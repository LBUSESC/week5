package uk.ac.leedsbeckett.post_service.entities;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document
public class Topic {
    @Id
    private Long topicId;
    private Long studentId;
    private String studentName;
    private String topicName;
    private String topicDate;
    private String topicContent;
}
