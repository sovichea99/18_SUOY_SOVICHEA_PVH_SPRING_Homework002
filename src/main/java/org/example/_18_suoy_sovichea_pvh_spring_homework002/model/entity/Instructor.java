package org.example._18_suoy_sovichea_pvh_spring_homework002.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Instructor {
    private long instructorId;
    private String instructorName;
    private String email;
}
