package org.example._18_suoy_sovichea_pvh_spring_homework002.controller;

import io.swagger.v3.oas.annotations.Operation;
import org.apache.ibatis.annotations.Param;
import org.example._18_suoy_sovichea_pvh_spring_homework002.model.entity.Courses;
import org.example._18_suoy_sovichea_pvh_spring_homework002.model.request.CourseRequest;
import org.example._18_suoy_sovichea_pvh_spring_homework002.model.response.ApiResponse;
import org.example._18_suoy_sovichea_pvh_spring_homework002.service.CourseService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.accept.ApiVersionStrategy;
import org.springframework.web.bind.annotation.*;

import java.time.Instant;
import java.util.List;

@RestController
@RequestMapping("/api/v1/courses")
public class CourseController {
    private final CourseService courseService;

    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }
    @Operation(summary = "Get all course")
    @GetMapping()
    public ResponseEntity<ApiResponse<List<Courses>>> getAllCourses(@RequestParam(defaultValue = "1") Integer page, @RequestParam(defaultValue = "10") Integer size){
        List<Courses> courses = courseService.getAllCourses(page, size);
        ApiResponse<List<Courses>> response = ApiResponse.<List<Courses>>builder()
                .success(true)
                .status(HttpStatus.OK.value())
                .message("Courses fetched successfully")
                .payload(courses)
                .timestamp(Instant.now())
                .build();
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }
    @Operation(summary = "Get course by ID")
    @GetMapping("/{course-id}")
    public ResponseEntity<ApiResponse<Courses>> getCoursesById(@PathVariable("course-id") long courseId){
        Courses courses = courseService.getCoursesById(courseId);
        ApiResponse<Courses> response = ApiResponse.<Courses>builder()
                .success(true)
                .status(HttpStatus.OK.value())
                .message("Courses fetched successfully")
                .payload(courses)
                .timestamp(Instant.now())
                .build();
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }
    @Operation(summary = "Create a new course")
    @PostMapping()
    public ResponseEntity<ApiResponse<Courses>> addCourse(@RequestBody CourseRequest request){
        Courses courses = courseService.addCourse(request);
        ApiResponse<Courses> response = ApiResponse.<Courses>builder()
                .success(true)
                .status(HttpStatus.OK.value())
                .message("Courses created successfully")
                .payload(courses)
                .timestamp(Instant.now())
                .build();
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }
    @Operation(summary = "Update course by ID")
    @PutMapping("/{course-id}")
    public ResponseEntity<ApiResponse<Courses>> updateCourse(@PathVariable("course-id") Long courseId  , @RequestBody CourseRequest request){
        Courses courses = courseService.updateCourse(courseId, request);
        ApiResponse<Courses> response = ApiResponse.<Courses>builder()
                .success(true)
                .status(HttpStatus.OK.value())
                .message("Courses updated successfully")
                .payload(courses)
                .timestamp(Instant.now())
                .build();
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @Operation(summary = "Delete course by ID")
    @DeleteMapping("/{course-id}")
    public ResponseEntity<ApiResponse<Courses>> deleteCourseById(@PathVariable("course-id") Long courseId){
        Courses courses = courseService.deleteCourseById(courseId);
        if( courses == null){
            ApiResponse<Courses> response = ApiResponse.<Courses>builder()
                    .success(false)
                    .status(HttpStatus.NOT_FOUND.value())
                    .message("No courses found with the given ID")
                    .timestamp(Instant.now())
                    .build();
            return ResponseEntity.status(HttpStatus.OK).body(response);
        }
        ApiResponse<Courses> response = ApiResponse.<Courses>builder()
                .success(true)
                .status(HttpStatus.OK.value())
                .message("Courses deleted successfully")
                .timestamp(Instant.now())
                .build();
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }
}
