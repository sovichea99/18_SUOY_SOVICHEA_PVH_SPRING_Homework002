package org.example._18_suoy_sovichea_pvh_spring_homework002.repository;

import org.apache.ibatis.annotations.*;
import org.example._18_suoy_sovichea_pvh_spring_homework002.model.entity.Courses;
import org.example._18_suoy_sovichea_pvh_spring_homework002.model.request.CourseRequest;

import java.util.List;

@Mapper
public interface CourseRepository {
    @Results(id = "courseMapper", value = {
            @Result(property = "courseId", column = "course_id"),
            @Result(property = "courseName", column = "course_name"),
            @Result(property = "instructor", column = "instructor_id",
                    one = @One(select = "org.example._18_suoy_sovichea_pvh_spring_homework002.repository.InstructorRepository.getInstructorById"))
    })
    @Select("""
    SELECT * FROM courses  order by course_id limit #{size} offset #{offset}
    """)
    List<Courses> getAllCourses(int offset, Integer size);


    @ResultMap("courseMapper")
    @Select("""
    SELECT * FROM courses WHERE course_id = #{courseId}
    """)
    Courses getCourseById(long courseId);

    @ResultMap("courseMapper")
    @Select("""
    INSERT INTO courses VALUES (default, #{req.courseName}, #{req.description}, #{req.instructorId}) RETURNING *
    """)
    Courses addCourse(@Param("req") CourseRequest request);

    @ResultMap("courseMapper")
    @Select("""
    UPDATE courses SET course_name = #{req.courseName}, description = #{req.description}, instructor_id = #{req.instructorId}
    WHERE course_id = #{courseId}
    RETURNING *
    """)
    Courses updateCourse(Long courseId, @Param("req")  CourseRequest request);


    @ResultMap("courseMapper")
    @Select("""
    DELETE FROM courses WHERE course_id = #{courseId} returning*
    """)
    Courses deleteCourseById(Long courseId);
}
