package com.unistudycircle.topic_service.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Data
@Entity
public class Topic {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long topicId;

    private String topicName;
    private LocalDate topicDate;
    @Lob
    private String topicContent;
    private Long studentId;
    private String studentName;
}
