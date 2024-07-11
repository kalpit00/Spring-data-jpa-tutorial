package com.kalpit00.Springdata.jpa.tutorial.repository;

import com.kalpit00.Springdata.jpa.tutorial.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

    // Jpa implements custom methods to fetch from database by itself!
    // It makes use of Hibernate internally, and follows the JPA logic to implement it.
    // So just name methods in camel case, and use EXACT attribute name
    // like, use findByFirstName or findAllByFirstName to get all "First Name" entries in db
    // DO NOt use findByFName or findFirstName, hibernate will be unable to recognize them
    // and implement its methods

    List<Student> findByFirstName(String firstName);
    List<Student> findByFirstNameContaining(String name);
    List<Student> findByLastNameNotNull();
    List<Student> findByGuardianName(String guardianName);
    List<Student> findByFirstNameAndLastName(String firstName, String lastName);
    // JPQL queries = similar to SQL queries, they are based on CLASS attributes, NOT Table names
    @Query("select s from Student s where s.emailId = ?1") // ?1 == first parameter, ?2 == second param..
    Student getStudentByEmailAddress(String emailId);

    @Query("select s.firstName from Student s where s.emailId = ?1")
    String getStudentFirstNameByEmailAddress(String emailId);
}
