package com.unistudycricle.student_service.services;

import com.unistudycricle.student_service.entities.Student;
import com.unistudycricle.student_service.exception.StudentNotFoundException;
import com.unistudycricle.student_service.repositories.StudentRepository;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

 private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public Student saveStudent(Student student){
        return studentRepository.save(student);
    }

    public Student getStudentById(Long studentId){
        return studentRepository.findById(studentId).orElseThrow(() -> new StudentNotFoundException("Student not found with id: " + studentId));
    }
}
