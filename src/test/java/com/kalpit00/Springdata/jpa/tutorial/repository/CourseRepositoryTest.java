package com.kalpit00.Springdata.jpa.tutorial.repository;

import com.kalpit00.Springdata.jpa.tutorial.entity.Course;
import com.kalpit00.Springdata.jpa.tutorial.entity.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CourseRepositoryTest {
    @Autowired
    private CourseRepository courseRepository;

    @Test
    public void printCourses() {
        List<Course> courses = courseRepository.findAll();
        for (Course course : courses) {
            System.out.println(course);
        }
    }

    @Test
    public void saveCourseWithTeacher() {
        Teacher teacher = Teacher.builder().firstName("James").lastName("Shah").build();
        Course course = Course.builder().courseTitle("Python").credit(6).teacher(teacher).build();
        courseRepository.save(course);
    }
}