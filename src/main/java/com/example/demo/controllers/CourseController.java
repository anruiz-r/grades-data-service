package com.example.demo.controllers;

import com.example.demo.models.Course;
import com.example.demo.models.Grade;
import com.example.demo.repositories.GradeRepository;
import com.example.demo.services.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/api/courses")
public class CourseController {
    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private CourseService courseService;

    @Autowired
    private GradeRepository gradeRepository;

    @GetMapping("/{courseCode}")
    @ResponseStatus(HttpStatus.OK)
    public Course getCourseInfo(@PathVariable Long courseCode) {
        return courseService.getCourseByCode(courseCode).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Course not found"));
    }



}
