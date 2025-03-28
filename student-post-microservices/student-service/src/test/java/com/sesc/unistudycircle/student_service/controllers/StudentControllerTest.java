package com.sesc.unistudycircle.student_service.controllers;

import org.junit.jupiter.api.Test;
import com.sesc.unistudycircle.student_service.services.StudentService;
import com.sesc.unistudycircle.student_service.entities.Student;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class StudentControllerTest {

    @Mock
    private StudentService studentService;

    @InjectMocks
    private StudentController studentController;

    private Student student;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        student = new Student("John", "Doe", "john.does@example.com", "Bsc", "University A");
    }

    @Test
    void createStudent() {
        // Arrange
        when(studentService.createStudent(any(Student.class))).thenReturn(student);

        // Act
        ResponseEntity<Student> response = studentController.createStudent(student);

        // Assert
        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertEquals(student, response.getBody());
        verify(studentService, times(1)).createStudent(student);
    }

    @Test
    void getStudentById() {
        when(studentService.getStudentById(1L)).thenReturn(student);

        ResponseEntity<Student> response = studentController.getStudentById(1L);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(student, response.getBody());
    }

    @Test
    void updateStudentById() {

        when(studentService.updateStudentById(eq(1L), any(Student.class))).thenReturn(student);

        ResponseEntity<Student> response = studentController.updateStudentById(1L, student);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(student, response.getBody());
    }

    @Test
    void deleteStudentById() {
        doNothing().when(studentService).deleteStudentById(1L);

        ResponseEntity<Void> response = studentController.deleteStudentById(1L);

        assertEquals(HttpStatus.NO_CONTENT, response.getStatusCode());
    }
}