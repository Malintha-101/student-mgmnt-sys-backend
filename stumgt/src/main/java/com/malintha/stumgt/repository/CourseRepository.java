package com.malintha.stumgt.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.malintha.stumgt.model.Course;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long>{
    
}