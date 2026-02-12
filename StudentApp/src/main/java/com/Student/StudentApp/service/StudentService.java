package com.Student.StudentApp.service;

import com.Student.StudentApp.entities.Student;
import com.Student.StudentApp.repository.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    @Autowired
    StudentRepo studentRepo;

    // This method retrieves all student records from the database using the findAll() method
    // provided by the JpaRepository interface.
//    public List<Student> getAllStudents() {
//        return studentRepo.findAll();
//    }
    //This will fetch only those students whose isDeleted is false,
    //effectively hiding the "deleted" records without actually removing them from the database.
    public List<Student> getAllStudents() {
        return studentRepo.findByIsDeletedFalse();
    }

    public Student getOneStudent(int id) {
        return studentRepo.findById(id).get();
    }

    public Student addStudent(Student student) {
        studentRepo.save(student);
        return student;
    }
// This method is removing the record from the database.
//    public void deleteStudent(int id) {
//        studentRepo.deleteById(id);
//    }


    public void deleteStudent(int id) {

        Student student = studentRepo.findById(id).orElseThrow(() -> new RuntimeException("Student not found"));

        student.setDeleted(true);   // mark as deleted
        studentRepo.save(student);    // update record instead of deleting
    }


//    public void updateStudent(int id, Student student) {
//        student.setId(id);
//        studentRepo.save(student);
//    }


    public void updateStudent(int id, Student student) {

        Student existing = studentRepo.findById(id).orElseThrow(() -> new RuntimeException("Student not found"));

        existing.setFirstName(student.getFirstName());
        existing.setLastName(student.getLastName());
        existing.setEmail(student.getEmail());
        existing.setDob(student.getDob());
        existing.setGender(student.getGender());
        existing.setAdmissionDate(student.getAdmissionDate());
        existing.setClassName(student.getClassName());
        existing.setCity(student.getCity());
        existing.setStateCode(student.getStateCode());
        existing.setCountry(student.getCountry());

        studentRepo.save(existing);
    }

}
