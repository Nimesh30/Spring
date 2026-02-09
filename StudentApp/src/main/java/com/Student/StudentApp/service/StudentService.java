package com.Student.StudentApp.service;

import com.Student.StudentApp.entities.Student;
import com.Student.StudentApp.repository.StudentRepo;
import org.hibernate.metamodel.model.domain.internal.ListAttributeImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentService {

    @Autowired
    StudentRepo studentRepo;
    public List<Student> getAllStudents() {
        return studentRepo.findAll();
    }

    public Student getOneStudent( int id) {
        return  studentRepo.findById(id).get();
    }

    public void addStudent(Student student) {
        studentRepo.save(student);
    }

    public void deleteStudent(int id) {
        studentRepo.deleteById(id);
    }

    public void updateStudent(int id, Student student) {
        student.setId(id);
        studentRepo.save(student);
    }
}
