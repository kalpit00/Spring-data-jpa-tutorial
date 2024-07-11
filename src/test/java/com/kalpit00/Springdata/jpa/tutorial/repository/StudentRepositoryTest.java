package com.kalpit00.Springdata.jpa.tutorial.repository;

import com.kalpit00.Springdata.jpa.tutorial.entity.Student;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class StudentRepositoryTest {
    @Autowired
    private StudentRepository studentRepository;

    @Test
    public void saveStudent() {
        Student student = Student.builder().emailId("kalpit@gmail.com").firstName("Kalpit").
            lastName("Patel").guardianName("Father").guardianEmail("Father@gmail.com")
            .guardianMobile("123456789").build();
        studentRepository.save(student);
    }
}