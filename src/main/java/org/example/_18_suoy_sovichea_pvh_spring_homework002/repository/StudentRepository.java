package org.example._18_suoy_sovichea_pvh_spring_homework002.repository;

import org.apache.ibatis.annotations.*;
import org.example._18_suoy_sovichea_pvh_spring_homework002.model.entity.Student;
import org.example._18_suoy_sovichea_pvh_spring_homework002.model.request.StudentRequest;

import java.util.List;

@Mapper
public interface StudentRepository {
    @Results(id = "studentMapper", value = {
            @Result(property = "studentId", column = "student_id"),
            @Result(property = "studentName", column = "student_name"),
            @Result(property = "email", column = "email"),
            @Result(property = "phoneNumber", column = "phone_number"),
            @Result(property = "courses", column = "student_id", many = @Many(select = "org.example._18_suoy_sovichea_pvh_spring_homework002.repository.StudentCourseRepository.getAllCourseByStudentId"))
    })
    @Select("""
    
            SELECT * FROM students order by student_id offset #{offset} limit #{size}
    """)
    List<Student> getAllStudent(Integer offset, Integer size);


    @ResultMap("studentMapper")
    @Select(
            """
    SELECT * FROM students WHERE student_id = #{studentId}
    """)
    Student getStudentById(Long studentId);

    @ResultMap("studentMapper")
    @Select("""
    INSERT INTO students VALUES (default, #{req.studentName}, #{req.email}, #{req.phoneNumber}) returning *
""")
    Student createNewStudent(@Param("req") StudentRequest request);

    @ResultMap("studentMapper")
    @Select("""
    UPDATE students SET student_name = #{req.studentName}, email = #{req.email}, phone_number = #{req.phoneNumber} WHERE student_id = #{studentId}
    """)
    Student updateStudent(Long studentId,@Param("req") StudentRequest request);

    @ResultMap("studentMapper")
    @Select("""
    DELETE FROM students where student_id = #{studentId}
    """)
    Student deleteStudentById(Long studentId);
}

