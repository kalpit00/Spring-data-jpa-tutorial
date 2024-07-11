package com.kalpit00.Springdata.jpa.tutorial.repository;

import com.kalpit00.Springdata.jpa.tutorial.entity.Course;
import com.kalpit00.Springdata.jpa.tutorial.entity.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class TeacherRepositoryTest {

    @Autowired
    private TeacherRepository teacherRepository;

    @Test
    public void saveTeacher() {
        Course course1 = Course.builder().courseTitle("Algos").credit(4).build();
        Course course2 = Course.builder().courseTitle("Architecture").credit(3).build();
        Teacher teacher = Teacher.builder().firstName("John").
                lastName("Doe")
                //.courses(List.of(course1, course2))
                .build();
        teacherRepository.save(teacher);
    }
}