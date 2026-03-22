package org.example._18_suoy_sovichea_pvh_spring_homework002.controller;

import io.swagger.v3.oas.annotations.Operation;
import org.example._18_suoy_sovichea_pvh_spring_homework002.model.entity.Student;
import org.example._18_suoy_sovichea_pvh_spring_homework002.model.request.StudentRequest;
import org.example._18_suoy_sovichea_pvh_spring_homework002.model.response.ApiResponse;
import org.example._18_suoy_sovichea_pvh_spring_homework002.service.StudentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.Instant;
import java.util.List;
@RestController
@RequestMapping("/api/v1/students")
public class StudentController {
    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @Operation(summary = "Get all students")
    @GetMapping("")
    public ResponseEntity<ApiResponse<List<Student>>> getAllStudents(@RequestParam(defaultValue = "1") Integer page, @RequestParam(defaultValue = "10") Integer size){
        List<Student> student = studentService.getAllStudents(page, size);
        ApiResponse<List<Student>> response = ApiResponse.<List<Student>>builder()
                .success(true)
                .status(HttpStatus.OK.value())
                .message("Students retrieved successfully")
                .payload(student)
                .timestamp(Instant.now())
                .build();
        return ResponseEntity.ok().body(response);
    }

    @Operation(summary = "Get students by ID")
    @GetMapping("/{student-id}")
    public ResponseEntity<ApiResponse<Student>> getStudentById(@PathVariable("student-id") Long studentId){
        Student student = studentService.getStudentById(studentId);
        if(student == null){
            ApiResponse<Student> response = ApiResponse.<Student>builder()
                    .success(false)
                    .status(HttpStatus.NOT_FOUND.value())
                    .message("No students found with the given ID")
                    .timestamp(Instant.now())
                    .build();
            return ResponseEntity.ok().body(response);
        }
        ApiResponse<Student> response = ApiResponse.<Student>builder()
                .success(true)
                .status(HttpStatus.OK.value())
                .message("Students retrieved successfully")
                .payload(student)
                .timestamp(Instant.now())
                .build();
        return ResponseEntity.ok().body(response);
    }

    @Operation(summary = "Create a new student")
    @PostMapping("")
    public ResponseEntity<ApiResponse<Student>> createNewStudent(@RequestBody StudentRequest request){
        Student student = studentService.createNewStudent(request);

        ApiResponse<Student> response = ApiResponse.<Student>builder()
                .success(true)
                .status(HttpStatus.OK.value())
                .message("Students created successfully")
                .payload(student)
                .timestamp(Instant.now())
                .build();
        return ResponseEntity.ok().body(response);
    }
    @Operation(summary = "Update student by ID")
    @PutMapping("/{student-id}")
    public ResponseEntity<ApiResponse<Student>> updateStudent(@PathVariable("student-id") Long studentId, @RequestBody StudentRequest request){
        Student student = studentService.updatetudent(studentId, request);
        if(student == null){
            ApiResponse<Student> response = ApiResponse.<Student>builder()
                    .success(false)
                    .status(HttpStatus.NOT_FOUND.value())
                    .message("No students found with the given ID")
                    .timestamp(Instant.now())
                    .build();
            return ResponseEntity.ok().body(response);
        }
        ApiResponse<Student> response = ApiResponse.<Student>builder()
                .success(true)
                .status(HttpStatus.OK.value())
                .message("Students updated successfully")
                .payload(student)
                .timestamp(Instant.now())
                .build();
        return ResponseEntity.ok().body(response);
    }

    @Operation(summary = "Delete student by ID")
    @DeleteMapping("/{student-id}")
    public ResponseEntity<ApiResponse<Student>> deleteStudent(@PathVariable("student-id") Long studentId){
        Student student = studentService.deleteStudent(studentId);
        if(student == null){
            ApiResponse<Student> response = ApiResponse.<Student>builder()
                    .success(false)
                    .status(HttpStatus.NOT_FOUND.value())
                    .message("No students found with the given ID")
                    .timestamp(Instant.now())
                    .build();
            return ResponseEntity.ok().body(response);
        }
        ApiResponse<Student> response = ApiResponse.<Student>builder()
                .success(true)
                .status(HttpStatus.OK.value())
                .message("Students deleted successfully")
                .timestamp(Instant.now())
                .build();
        return ResponseEntity.ok().body(response);
    }
}
