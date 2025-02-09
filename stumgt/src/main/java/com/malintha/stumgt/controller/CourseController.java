package com.malintha.stumgt.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.malintha.stumgt.dto.course.CourseDTO;
import com.malintha.stumgt.model.Course;
import com.malintha.stumgt.service.CourseService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;



@RestController
@RequestMapping("/api/courses")
public class CourseController {
   
    @Autowired
    private CourseService courseService;

    // create course
    @PostMapping("/create")
    public Course creatCourse(@RequestBody Course course) {
        return courseService.createCourse(course);
    }

    // get all courses
    @GetMapping("/all")
    public ResponseEntity<List<CourseDTO>> getAllCourses() {
        List<CourseDTO> courses = courseService.getAllCourses();
        return ResponseEntity.ok(courses);
    }
    
    // get course by id
    @GetMapping("/get/{id}")
    public Course getCourseById(@PathVariable Long id) {
        return courseService.getCourseById(id);
    }

    // update course
    @PutMapping("/update/{id}")
    public Course updateCourse(@RequestBody Course course, @PathVariable Long id) {
        return courseService.updateCourse(course);
    }

    // delete course
    @DeleteMapping("/delete/{id}")
    public void deleteCourse(@PathVariable Long id) {
        courseService.deleteCourse(id);
    }
}
