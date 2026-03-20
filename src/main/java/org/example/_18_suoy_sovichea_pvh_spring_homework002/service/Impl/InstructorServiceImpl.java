package org.example._18_suoy_sovichea_pvh_spring_homework002.service.Impl;

import org.example._18_suoy_sovichea_pvh_spring_homework002.model.entity.Instructor;
import org.example._18_suoy_sovichea_pvh_spring_homework002.model.request.InstructorRequest;
import org.example._18_suoy_sovichea_pvh_spring_homework002.repository.InstructorRepository;
import org.example._18_suoy_sovichea_pvh_spring_homework002.service.InstructorService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InstructorServiceImpl implements InstructorService {
    private final InstructorRepository instructorRepository;

    public InstructorServiceImpl(InstructorRepository instructorRepository) {
        this.instructorRepository = instructorRepository;
    }

    @Override
    public List<Instructor> getAllInstructor(Integer page, Integer size) {
        int offset = (page - 1 ) * size;
        return instructorRepository.getAllInstructor(offset, size);
    }

    @Override
    public Instructor getInstructorById(long instructorId) {
        return instructorRepository.getInstructorById(instructorId);
    }

    @Override
    public Instructor addInstructor(InstructorRequest request) {
        return instructorRepository.addInstructor(request);
    }

    @Override
    public Instructor updateInstructor(long instructorId, InstructorRequest request) {
        return instructorRepository.updateInstructor(instructorId, request);
    }

    @Override
    public Instructor deleteInstructorById(long instructorId) {
        return instructorRepository.deleteInstructorById(instructorId);
    }

}
