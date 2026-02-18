package com.Student.StudentApp.controller;

import com.Student.StudentApp.dto.UploadResponse;
import com.Student.StudentApp.entities.Student;
import com.Student.StudentApp.service.StudentService;
import com.Student.StudentApp.service.UploadService;
//import com.Student.StudentApp.service.;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Map;

//@CrossOrigin(
//        origins = "http://localhost:5173"
//)
@CrossOrigin("*")
@RequestMapping("/students")
@RestController
public class StudentController {

    @Autowired
    StudentService studentService;
    @Autowired
    UploadService uploadService;

    // Get All students
    @GetMapping
    public List<Student> getAllStudent() {
        return studentService.getAllStudents();
    }

    //Get student By id
    @GetMapping("/{id}")
    public Student getStudentById(@PathVariable int id) {
        return studentService.getOneStudent(id);
    }

    //Add student
    @PostMapping
    public void addStudent(@RequestBody Student student) {
        studentService.addStudent(student);
    }

    //Delete student
    @DeleteMapping("/{id}")
    public void deleteStudent(@PathVariable int id) {
        studentService.deleteStudent(id);
    }

    //Update the data
    @PutMapping("/{id}")
    public void updateStudent(@PathVariable int id, @RequestBody Student student) {
        studentService.updateStudent(id, student);
    }

    @PostMapping("/upload")
    public ResponseEntity<?> uploadImage(@RequestParam("file") MultipartFile file) throws IOException {
        System.out.println("In Image Controller");
//        Map result = uploadService.uploadImage(file);
        UploadResponse response = uploadService.uploadImage(file);
        return ResponseEntity.ok(response);
    }

}
