package org.example._18_suoy_sovichea_pvh_spring_homework002.repository;

import org.apache.ibatis.annotations.*;
import org.example._18_suoy_sovichea_pvh_spring_homework002.model.entity.Instructor;
import org.example._18_suoy_sovichea_pvh_spring_homework002.model.request.InstructorRequest;


import java.util.List;

@Mapper
public interface InstructorRepository {
    @Results(id = "instructorMapper", value = {
            @Result(property = "instructorId", column = "instructor_id"),
            @Result(property = "instructorName", column = "instructor_name"),
            @Result(property = "email", column = "instructor_email")
    })
    @Select("SELECT * FROM instructor order by instructor_id limit #{size} offset #{offset}")
    List<Instructor> getAllInstructor(@Param("offset") Integer offset, @Param("size") Integer size);

    @ResultMap("instructorMapper")
    @Select("SELECT * FROM instructor where instructor_id = #{instructorId}")
    Instructor getInstructorById(long instructorId);

    @ResultMap("instructorMapper")
    @Select("""
    INSERT INTO instructor VALUES (default, #{req.instructorName}, #{req.email}) RETURNING *
    """)
    Instructor addInstructor(@Param("req") InstructorRequest request);

    @ResultMap("instructorMapper")
    @Select("""
    UPDATE instructor SET instructor_name = #{req.instructorName}, instructor_email = #{req.email}
    WHERE instructor_id = #{instructorId}
    RETURNING *
    """)
    Instructor updateInstructor(long instructorId,@Param("req") InstructorRequest request);


    @ResultMap("instructorMapper")
    @Select("""
    DELETE FROM instructor WHERE instructor_id = #{instructorId} RETURNING *
""")
    Instructor deleteInstructorById(long instructorId);

}
