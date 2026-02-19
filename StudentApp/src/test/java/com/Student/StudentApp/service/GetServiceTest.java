package com.Student.StudentApp.service;

import com.Student.StudentApp.entities.Student;
import com.Student.StudentApp.repository.StudentRepo;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@ExtendWith(MockitoExtension.class)
public class GetServiceTest {

    @Mock
    StudentRepo studentRepo;

    @InjectMocks
    StudentService studentService;

    @Test
    void shouldReturnAllNonDeletedStudents() {
        // Prepare test data
        Student student1 = new Student();
        student1.setId(1);
        student1.setFirstName("Nimesh");

        Student student2 = new Student();
        student2.setId(2);
        student2.setFirstName("Amit");

        List<Student> mockStudents = Arrays.asList(student1, student2);

        //Return only non-deleted students
        //because we are not delete record from the database. (Soft delete)
        Mockito.when(studentRepo.findByIsDeletedFalse()).thenReturn(mockStudents);

        // Call service method
        List<Student> students = studentService.getAllStudents();

        // Assertions
        assertNotNull(students, "return list should not be null");
        assertEquals(2, students.size(), "2 student returned");
        assertEquals("Nimesh", students.get(0).getFirstName());
        assertEquals("Amit", students.get(1).getFirstName());
    }
}
