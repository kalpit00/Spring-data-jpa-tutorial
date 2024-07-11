package com.kalpit00.Springdata.jpa.tutorial.repository;

import com.kalpit00.Springdata.jpa.tutorial.entity.Course;
import com.kalpit00.Springdata.jpa.tutorial.entity.Student;
import com.kalpit00.Springdata.jpa.tutorial.entity.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.data.domain.Pageable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

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

    @Test
    public void findAllPagination() {
        Pageable firstPageWithThreeRecords = PageRequest.of(0, 3);
        Pageable secondPageWithThreeRecords = PageRequest.of(1, 2);
        List<Course> courses = courseRepository.findAll(secondPageWithThreeRecords).getContent();

        Long totalElements = courseRepository.findAll(firstPageWithThreeRecords).getTotalElements();
        int totalPages = courseRepository.findAll(firstPageWithThreeRecords).getTotalPages();
        System.out.println(totalElements);
        System.out.println(totalPages);
        for (Course course : courses) {
            System.out.println(course);
        }
    }

    @Test
    public void findAllSorting() {
        Pageable sortByTitle = PageRequest.of(0, 2, Sort.by("courseTitle"));
        Pageable sortByCreditDesc = PageRequest.of(0, 2,
                Sort.by("credit").descending());
        Pageable sortByTitleAndCreditDesc = PageRequest.of(0, 2,
                Sort.by("courseTitle").
                        descending().and(Sort.by("credit").descending()));

        List<Course> courses = courseRepository.findAll(sortByTitle).getContent();
        for (Course course : courses) {
            System.out.println(course);
        }
    }

    @Test
    public void findByTitleContaining() {
        Pageable firstPageTenRecords = PageRequest.of(0, 10);
        List<Course> courses = courseRepository.findByCourseTitleContaining
                ("A", firstPageTenRecords).getContent();
        for (Course course : courses) {
            System.out.println(course);
        }
    }

    @Test
    public void saveCourseWithStudentAndTeacher() {
        Teacher teacher = Teacher.builder().firstName("Bob").lastName("Miller").build();
        Course course = Course.builder().courseTitle("AI").credit(12).teacher(teacher).build();
        Student student = Student.builder().firstName("Kalpit").lastName("Patel").emailId("kalpit").build();
        course.addStudents(student);
        courseRepository.save(course);
    }
}