package com.malintha.stumgt.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.malintha.stumgt.model.Student;
import com.malintha.stumgt.repository.StudentRepository;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    // get all students
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    // create student
    public Student createStudent(Student student) {
        return studentRepository.save(student);
    }

    // get student by id
    public Student getStudentById(Long id) {
        return studentRepository.findById(id).orElse(null);
    }

    // update student
    public Student updateStudent(Student student) {
        return studentRepository.save(student);
    }

    // delete student
    public void deleteStudent(Long id) {
        studentRepository.deleteById(id);
    }

}
