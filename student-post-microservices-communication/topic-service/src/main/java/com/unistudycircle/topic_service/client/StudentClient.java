package com.unistudycircle.topic_service.client;

import com.unistudycircle.topic_service.dtos.StudentInfo;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.service.annotation.GetExchange;
import org.springframework.web.service.annotation.HttpExchange;

@Component
@HttpExchange(url = "http://localhost:8080/api/v1/students/")
public interface StudentClient {

    @GetExchange("/{studentId}")
    public ResponseEntity<StudentInfo> getStudent(@PathVariable Long studentId);
}
