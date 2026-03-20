package org.example._18_suoy_sovichea_pvh_spring_homework002.service.Impl;

import org.example._18_suoy_sovichea_pvh_spring_homework002.model.entity.Student;
import org.example._18_suoy_sovichea_pvh_spring_homework002.model.request.StudentRequest;
import org.example._18_suoy_sovichea_pvh_spring_homework002.repository.StudentCourseRepository;
import org.example._18_suoy_sovichea_pvh_spring_homework002.repository.StudentRepository;
import org.example._18_suoy_sovichea_pvh_spring_homework002.service.StudentService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {
    private final StudentRepository studentRepository;
    private final StudentCourseRepository studentCourseRepository;

    public StudentServiceImpl(StudentRepository studentRepository, StudentCourseRepository studentCourseRepository) {
        this.studentRepository = studentRepository;
        this.studentCourseRepository = studentCourseRepository;
    }

    @Override
    public List<Student> getAllStudents(Integer page, Integer size) {
        int offset = (page - 1 ) * size;
        return studentRepository.getAllStudent(offset, size);
    }

    @Override
    public Student getStudentById(Long studentId) {
        return studentRepository.getStudentById(studentId);
    }

    @Override
    public Student createNewStudent(StudentRequest request) {
        Student student = studentRepository.createNewStudent(request);
        //save each course
        if (request.getCourseIds() != null) {
            for (Long courseId : request.getCourseIds()) {
                studentCourseRepository.saveCourse(student.getStudentId(), courseId);
            }
        }
        return studentRepository.getStudentById(student.getStudentId());
    }

    @Override
    public Student updatetudent(Long studentId, StudentRequest request) {
        Student student = studentRepository.getStudentById(studentId);
        if(student == null){
            return null;
        }
        studentRepository.updateStudent(studentId, request);

        studentCourseRepository.deleteCourseByStudentId(studentId);

        if(request.getCourseIds() != null){
            for (Long courseId : request.getCourseIds()){
                studentCourseRepository.saveCourse(studentId, courseId);
            }
        }
        return studentRepository.getStudentById(studentId);
    }

    @Override
    public Student deleteStudent(Long studentId) {
        Student student = studentRepository.getStudentById(studentId);
        if(student == null){
            return null;
        }
        studentCourseRepository.deleteCourseByStudentId(studentId);
        studentRepository.deleteStudentById(studentId);
        return student;
    }
}
