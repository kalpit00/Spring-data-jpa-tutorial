package com.kalpit00.Springdata.jpa.tutorial.repository;

import com.kalpit00.Springdata.jpa.tutorial.entity.Course;
import com.kalpit00.Springdata.jpa.tutorial.entity.CourseMaterial;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CourseMaterialRepositoryTest {

    @Autowired
    private CourseMaterialRepository courseMaterialRepository;

    @Test
    public void saveCourseMaterial() {
        Course course = Course.builder().courseTitle("DSA").credit(3).build();
        CourseMaterial courseMaterial = CourseMaterial.builder().url("google").course(course).build();
        courseMaterialRepository.save(courseMaterial);
    }

    @Test
    public void printCourseMaterial() {
        List<CourseMaterial> courseMaterials = courseMaterialRepository.findAll();
        for (CourseMaterial courseMaterial : courseMaterials) {
            System.out.println(courseMaterial);
        }
    }
}