package org.example._18_suoy_sovichea_pvh_spring_homework002.service;

import org.example._18_suoy_sovichea_pvh_spring_homework002.model.entity.Instructor;
import org.example._18_suoy_sovichea_pvh_spring_homework002.model.request.InstructorRequest;
import org.springframework.stereotype.Service;

import java.util.List;

public interface InstructorService {
    List<Instructor> getAllInstructor(Integer page, Integer size);

    Instructor getInstructorById(long instructorId);

    Instructor addInstructor(InstructorRequest request);

    Instructor updateInstructor(long instructorId, InstructorRequest request);

    Instructor deleteInstructorById(long instructorId);
}
