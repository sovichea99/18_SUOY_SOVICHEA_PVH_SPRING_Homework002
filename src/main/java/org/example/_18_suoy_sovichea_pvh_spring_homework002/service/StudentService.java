package org.example._18_suoy_sovichea_pvh_spring_homework002.service;

import org.example._18_suoy_sovichea_pvh_spring_homework002.model.entity.Student;
import org.example._18_suoy_sovichea_pvh_spring_homework002.model.request.StudentRequest;

import java.util.List;

public interface StudentService {
    List<Student> getAllStudents(Integer page, Integer size);

    Student getStudentById(Long studentId);

    Student createNewStudent(StudentRequest request);

    Student updatetudent(Long studentId, StudentRequest request);

    Student deleteStudent(Long studentId);
}
