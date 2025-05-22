package com.example.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor

public class CourseGradeDTO {
    private Long courseCode;
    private Long studentId;
    private String studentName;
    private int grade;

}
