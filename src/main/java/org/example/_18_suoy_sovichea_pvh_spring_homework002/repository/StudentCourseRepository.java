package org.example._18_suoy_sovichea_pvh_spring_homework002.repository;

import org.apache.ibatis.annotations.*;
import org.example._18_suoy_sovichea_pvh_spring_homework002.model.entity.Courses;

import java.util.List;

@Mapper
public interface StudentCourseRepository {
    @Results(id = "studentcourseMapper", value = {
            @Result(property = "courseId", column = "course_id"),
            @Result(property = "courseName", column = "course_name"),
            @Result(property = "instructor", column = "instructor_id",
                    one = @One(select = "org.example._18_suoy_sovichea_pvh_spring_homework002.repository.InstructorRepository.getInstructorById"))
    })
    @Select("""
    SELECT c.* FROM student_course sc INNER JOIN courses c ON sc.course_id = c.course_id WHERE sc.student_id = #{studentId}
    """)
    List<Courses> getAllCourseByStudentId(Long studentId);

    @Insert("""
    INSERT INTO student_course (student_id, course_id)
    VALUES (#{studentId}, #{courseId})
    """)
    void saveCourse(Long studentId, Long courseId);

    @Delete("""
    DELETE FROM student_course WHERE student_id = #{studentId}
    """)
    void deleteCourseByStudentId(Long studentId);
}
