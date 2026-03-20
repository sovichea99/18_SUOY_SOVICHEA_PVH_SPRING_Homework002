package org.example._18_suoy_sovichea_pvh_spring_homework002.service.Impl;

import org.example._18_suoy_sovichea_pvh_spring_homework002.model.entity.Courses;
import org.example._18_suoy_sovichea_pvh_spring_homework002.model.request.CourseRequest;
import org.example._18_suoy_sovichea_pvh_spring_homework002.repository.CourseRepository;
import org.example._18_suoy_sovichea_pvh_spring_homework002.service.CourseService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseServiceImpl implements CourseService {
    private final CourseRepository courseRepository;

    public CourseServiceImpl(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    @Override
    public List<Courses> getAllCourses(Integer page, Integer size) {
        int offset = (page - 1) * size;
        return courseRepository.getAllCourses(offset, size);
    }

    @Override
    public Courses getCoursesById(long courseId) {
        return courseRepository.getCourseById(courseId);
    }

    @Override
    public Courses addCourse(CourseRequest request) {
        return courseRepository.addCourse(request);
    }

    @Override
    public Courses updateCourse(Long courseId, CourseRequest request) {
        return courseRepository.updateCourse(courseId, request);
    }

    @Override
    public Courses deleteCourseById(Long courseId) {
       return courseRepository.deleteCourseById(courseId);
    }
}
