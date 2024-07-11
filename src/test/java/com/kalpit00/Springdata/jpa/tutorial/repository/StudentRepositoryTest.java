package com.kalpit00.Springdata.jpa.tutorial.repository;

import com.kalpit00.Springdata.jpa.tutorial.entity.Guardian;
import com.kalpit00.Springdata.jpa.tutorial.entity.Student;
import org.junit.jupiter.api.Disabled;
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
    @Disabled
    public void saveStudentWithGuardian() {
        Guardian guardian = Guardian.builder().name("Father").email("Father@gmail.com").
                mobile("123456789").build();
        Student student = Student.builder().emailId("1").firstName("Keith").
                lastName("Patel").guardian(guardian).build();
        studentRepository.save(student);
    }

    @Test
    public void printAllStudent() {
        List<Student> studentList = studentRepository.findAll();
        for (Student student : studentList) {
            System.out.println("student = " + student);
        }
    }

    @Test
    public void printStudentByFirstName() {
        List<Student> studentList = studentRepository.findByFirstName("John");
        for (Student student : studentList) {
            System.out.println("student = " + student);
        }
    }

    @Test
    public void printStudentByFirstNameContaining() {
        List<Student> studentList = studentRepository.findByFirstNameContaining("K");
        for (Student student : studentList) {
            System.out.println("student = " + student);
        }
    }


    @Test
    public void printStudentByLastNameNonNull() {
        List<Student> studentList = studentRepository.findByLastNameNotNull();
        for (Student student : studentList) {
            System.out.println("student = " + student);
        }
    }

    @Test
    public void printStudentByGuardianName() {
        List<Student> studentList = studentRepository.findByGuardianName("Father");
        for (Student student : studentList) {
            System.out.println("student = " + student);
        }
    }

    @Test
    public void printStudentByFirstNameAndLastName() {
        List<Student> studentList = studentRepository.findByFirstNameAndLastName("Kalpit", "Patel");
        for (Student student : studentList) {
            System.out.println("student = " + student);
        }
    }

    @Test
    public void printStudentByEmailAddress() {
        Student student = studentRepository.getStudentByEmailAddress("kalpit@gmail.com");
        System.out.println(student);
    }

    @Test
    public void printStudentFirstNameByEmailAddress() {
        String studentFirstName = studentRepository.getStudentFirstNameByEmailAddress("kalpit@gmail.com");
        System.out.println(studentFirstName);
    }

    @Test
    public void printStudentByEmailAddressNative() {
        Student student = studentRepository.getStudentByEmailAddressNative("kalpit@gmail.com");
        System.out.println(student);
    }

    @Test
    public void printStudentByEmailAddressNativeNamedParam() {
        Student student = studentRepository.getStudentByEmailAddressNativeNamedParam("kalpit@gmail.com");
        System.out.println(student);
    }

    @Test
    public void updateStudentNameByEmailAddress() {
        studentRepository.updateStudentNameByEmailId("OldKalpit", "kalpit@gmail.com");
    }


}