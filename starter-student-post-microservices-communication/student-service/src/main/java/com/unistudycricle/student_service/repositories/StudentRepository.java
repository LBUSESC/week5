package com.unistudycricle.student_service.repositories;

import com.unistudycricle.student_service.entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {
}
