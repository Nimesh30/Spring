package com.Student.StudentApp.service;

import com.Student.StudentApp.entities.Student;
import com.Student.StudentApp.repository.StudentRepo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@ExtendWith(MockitoExtension.class)
public class StudentServiceTest {

    @Mock
    StudentRepo studentRepo;
    @InjectMocks
    StudentService studentService;
    @Test
    void shouldAddStudentSuccessfully(){
        System.out.println("This is a demo test");

        //Data set up - preparing the data for testing
        Student student = new Student();
        student.setId(1);
        student.setFirstName("Nimesh");
        student.setLastName("Prajapati");
        student.setEmail("nimesh@gmail.com");
        student.setDob("30/06/2004");
        student.setGender("Male");
        student.setAdmissionDate(new Date());
        student.setCity("Shanghai");
        student.setCountry("China");
        student.setClassName("A");
        student.setStateCode("GJ");

        //Mocking the repository method - defining the behavior of the mocked repository
        Mockito.when(studentRepo.save(student)).thenReturn(student);
        // addStudent will return student object which we set above...
        Student addedStudent = studentService.addStudent(student);
        System.out.println("Student added successfully");

        //Assertions - verifying the results of the test
            assertNotNull(addedStudent);
        assertEquals(student.getId(),addedStudent.getId());
        assertEquals("Nimesh",addedStudent.getFirstName());
        assertEquals(student.getLastName(),addedStudent.getLastName());
        assertEquals(student.getEmail(),addedStudent.getEmail());
        assertEquals(student.getDob(),addedStudent.getDob());
        assertEquals(student.getGender(),addedStudent.getGender());
        assertEquals(student.getAdmissionDate(),addedStudent.getAdmissionDate());
        assertEquals(student.getClassName(),addedStudent.getClassName());
        assertEquals(student.getCity(),addedStudent.getCity());
        assertEquals(student.getStateCode(),addedStudent.getStateCode());
        assertEquals(student.getCountry(),addedStudent.getCountry());
    }
}
