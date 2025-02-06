package com.malintha.stumgt.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.malintha.stumgt.model.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
}
