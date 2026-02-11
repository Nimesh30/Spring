package com.Student.StudentApp.repository;

import com.Student.StudentApp.entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepo extends JpaRepository<Student, Integer> {


    List<Student> findByIsDeletedFalse();




}
