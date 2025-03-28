package com.sesc.unistudycircle.student_service.services;

import com.sesc.unistudycircle.student_service.entities.Student;
import com.sesc.unistudycircle.student_service.exceptions.StudentNotFoundException;
import com.sesc.unistudycircle.student_service.repositories.StudentRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class StudentServiceImplTest {

    @Mock
    private StudentRepository studentRepository;

    @InjectMocks
    private StudentServiceImpl studentService;

    private Student student;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        student = new Student("John", "Doe", "john.doe@example.com", "BSc", "University A");
    }

    @Test
    void createStudent_ShouldReturnCreatedStudent() {
        when(studentRepository.save(any(Student.class))).thenReturn(student);

        Student createdStudent = studentService.createStudent(student);

        assertNotNull(createdStudent);
        assertEquals("John", createdStudent.getFirstName());
        verify(studentRepository, times(1)).save(student);
    }

    @Test
    void getStudentById_ShouldReturnStudent_WhenExists() {
        when(studentRepository.findById(1L)).thenReturn(Optional.of(student));

        Student foundStudent = studentService.getStudentById(1L);

        assertNotNull(foundStudent);
        assertEquals("John", foundStudent.getFirstName());
        verify(studentRepository, times(1)).findById(1L);
    }

    @Test
    void getStudentById_ShouldThrowException_WhenNotFound() {
        when(studentRepository.findById(1L)).thenReturn(Optional.empty());

        assertThrows(StudentNotFoundException.class, () -> studentService.getStudentById(1L));
    }

    @Test
    void deleteStudentById_ShouldDeleteStudent_WhenExists() {
        when(studentRepository.existsById(1L)).thenReturn(true);

        studentService.deleteStudentById(1L);

        verify(studentRepository, times(1)).deleteById(1L);
    }

    @Test
    void deleteStudentById_ShouldThrowException_WhenNotFound() {
        when(studentRepository.existsById(1L)).thenReturn(false);

        assertThrows(StudentNotFoundException.class, () -> studentService.deleteStudentById(1L));
    }

    @Test
    void updateStudentById_ShouldUpdateStudent_WhenExists() {
        when(studentRepository.existsById(1L)).thenReturn(true);
        when(studentRepository.save(any(Student.class))).thenReturn(student);

        Student updatedStudent = studentService.updateStudentById(1L, student);

        assertNotNull(updatedStudent);
        verify(studentRepository, times(1)).save(student);
    }

    @Test
    void updateStudentById_ShouldThrowException_WhenNotFound() {
        when(studentRepository.existsById(1L)).thenReturn(false);

        assertThrows(StudentNotFoundException.class, () -> studentService.updateStudentById(1L, student));
    }
}