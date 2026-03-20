package org.example._18_suoy_sovichea_pvh_spring_homework002.service;

import org.example._18_suoy_sovichea_pvh_spring_homework002.model.entity.Courses;
import org.example._18_suoy_sovichea_pvh_spring_homework002.model.request.CourseRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CourseService {
    List<Courses> getAllCourses(Integer page, Integer size);

    Courses getCoursesById(long courseId);

    Courses addCourse(CourseRequest request);

    Courses updateCourse(Long courseId, CourseRequest request);

    Courses deleteCourseById(Long courseId);
}
