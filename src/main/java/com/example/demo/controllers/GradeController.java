package com.example.demo.controllers;

import com.example.demo.dto.CourseGradeDTO;
import com.example.demo.dto.StudentInfoDTO;
import com.example.demo.models.Grade;
import com.example.demo.repositories.GradeRepository;
import com.example.demo.services.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/grades")
public class GradeController {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private GradeRepository gradeRepository;


    @GetMapping
    public List<Grade> getAllGrades() {
        return gradeRepository.findAll();
    }

    @GetMapping("/{courseCode}")
    @ResponseStatus(HttpStatus.OK)
    public List<CourseGradeDTO> getGradesByCourseCode(@PathVariable Long courseCode) {
        List<Grade> grades = gradeRepository.findByCourseCode(courseCode);
        if (grades.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No grades found for this course");
        }
        List<CourseGradeDTO> courseGradeDTOS = new ArrayList<>();;
        for (Grade grade : grades) {
            StudentInfoDTO studentInfo = restTemplate.getForObject("http://localhost:8082/api/students/" + grade.getStudentId(), StudentInfoDTO.class);
            System.out.println(studentInfo);
            CourseGradeDTO courseGrade = new CourseGradeDTO(courseCode, grade.getStudentId(), studentInfo.getName(), grade.getGrade());
            courseGradeDTOS.add(courseGrade);
        }
        return courseGradeDTOS;
    }

}