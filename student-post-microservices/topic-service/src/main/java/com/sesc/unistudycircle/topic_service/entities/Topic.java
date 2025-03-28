package com.sesc.unistudycircle.topic_service.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Data
@Entity
@Table(name = "tb_topics")
public class Topic {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long topicId;

    private String topicName;

    private String topicDate ;

    @Lob
    private String topicContent;

    private Long studentId;

    public Topic(Long topicId, String topicName, String topicDate, String topicContent, Long studentId, String studentName) {
        this.topicId = topicId;
        this.topicName = topicName;
        this.topicDate = topicDate;
        this.topicContent = topicContent;
        this.studentId = studentId;
        this.studentName = studentName;
    }

    private String studentName;
}
