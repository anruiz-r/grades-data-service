package com.example.demo.dto;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor

public class CourseGradeDTO {
    private Long courseCode;
    private Long studentId;
    private String studentName;
    private String grade;

}
