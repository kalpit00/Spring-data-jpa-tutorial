package com.kalpit00.Springdata.jpa.tutorial.repository;

import com.kalpit00.Springdata.jpa.tutorial.entity.Guardian;
import com.kalpit00.Springdata.jpa.tutorial.entity.Student;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class StudentRepositoryTest {
    @Autowired
    private StudentRepository studentRepository;

//    @Test
//    public void saveStudent() {
//        Student student = Student.builder().emailId("kalpit@gmail.com").firstName("Kalpit").
//            lastName("Patel").guardianName("Father").guardianEmail("Father@gmail.com")
//            .guardianMobile("123456789").build();
//        studentRepository.save(student);
//    }

    @Test
    public void saveStudentWithGuardian() {
        Guardian guardian = Guardian.builder().name("Father").email("Father@gmail.com").
                mobile("123456789").build();
        Student student = Student.builder().emailId("kalpit2@gmail.com").firstName("Kalpit").
                lastName("Patel").guardian(guardian).build();
        studentRepository.save(student);
    }

    @Test
    public void printAllStudent() {
        List<Student> studentList = studentRepository.findAll();
        System.out.println("studentList = " + studentList);
    }
}