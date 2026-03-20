package org.example._18_suoy_sovichea_pvh_spring_homework002.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Courses {
    private long courseId;
    private String courseName;
    private String description;
    private Instructor instructor;
}
