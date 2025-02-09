package com.malintha.stumgt.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import com.malintha.stumgt.model.Student;
import com.malintha.stumgt.repository.StudentRepository;
import com.malintha.stumgt.dto.student.StudentDTO;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    // get all students
    public List<StudentDTO> getAllStudents() {
        List<Student> students = studentRepository.findAll();
        return students.stream().map(this::mapToStudentDTO).toList();
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

    private StudentDTO mapToStudentDTO(Student student) {
        return new StudentDTO(student.getId(), student.getName(), student.getEmail(), student.getAddress(), student.getDob(), student.getPhone());
    }

}
