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

import java.util.Optional;

@ExtendWith(MockitoExtension.class)
public class DeleteServiceTest {

    @Mock
    private StudentRepo studentRepo;

    @InjectMocks
    private StudentService studentService;

    @Test
    void shouldDeleteStudentSuccessfully() {

        // Data setup
        Student student = new Student();
        student.setId(1);
        student.setDeleted(false);

        // Mock repository behavior
        Mockito.when(studentRepo.findById(1)).thenReturn(Optional.of(student));
        Mockito.when(studentRepo.save(student)).thenReturn(student);

        // Call method
        studentService.deleteStudent(1);

        // Assertions
        Assertions.assertTrue(student.isDeleted());

        // Verify interactions
//        Mockito.verify(studentRepo).findById(1);
//        Mockito.verify(studentRepo).save(student);

        System.out.println("Student deleted successfully");
    }

    @Test
    void shouldThrowExceptionWhenStudentNotFound() {

        // Mock repository behavior
        Mockito.when(studentRepo.findById(1 )).thenReturn(Optional.empty());

        // Assertion
        RuntimeException exception = Assertions.assertThrows(
                RuntimeException.class,
                () -> studentService.deleteStudent(2)
        );

        Assertions.assertEquals("Student not found", exception.getMessage());

        // Verify findById was called
//        Mockito.verify(studentRepo).findById(2);
    }
}
