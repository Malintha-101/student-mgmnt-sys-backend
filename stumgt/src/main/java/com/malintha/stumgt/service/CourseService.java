package com.malintha.stumgt.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.malintha.stumgt.model.Course;
import com.malintha.stumgt.repository.CourseRepository;

@Service
public class CourseService {
    
    @Autowired
    private CourseRepository courseRepository;

    // get all courses
    public List<Course> getAllCourses() {
        return courseRepository.findAll();
    }

    // create course
    public Course createCourse(Course course) {
        return courseRepository.save(course);
    }

    // get course by id
    public Course getCourseById(Long id) {
        return courseRepository.findById(id).orElse(null);
    }

    // update course
    public Course updateCourse(Course course) {
        return courseRepository.save(course);
    }

    // delete course
    public void deleteCourse(Long id) {
        courseRepository.deleteById(id);
    }
}
