package com.malintha.stumgt.service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.malintha.stumgt.dto.entrollment.CreateEntrollmentDTO;
import com.malintha.stumgt.dto.entrollment.EntrollmentResponseDTO;
import com.malintha.stumgt.model.Batch;
import com.malintha.stumgt.model.Entrollement;
import com.malintha.stumgt.model.Student;
import com.malintha.stumgt.repository.BatchRepository;
import com.malintha.stumgt.repository.EntrollmentRepository;
import com.malintha.stumgt.repository.StudentRepository;

import jakarta.transaction.Transactional;

@Service
public class EntrollmentService {
    @Autowired
    private EntrollmentRepository entrollmentRepository;

    @Autowired
    private BatchRepository batchRepository;

    @Autowired
    private StudentRepository studentRepository;

    // create entrollments for a student with multiple batch IDs
    public List<Entrollement> createEntrollments(CreateEntrollmentDTO createEntrollmentDTO) {
        Student student = studentRepository.findById(createEntrollmentDTO.getStudentId()).orElse(null);
        if (student == null) {
            throw new IllegalArgumentException("Invalid student ID");
        }

        List<Batch> batches = batchRepository.findAllById(createEntrollmentDTO.getBatchIds());
        if (batches.isEmpty()) {
            throw new IllegalArgumentException("Invalid batch IDs");
        }

        List<Entrollement> entrollments = batches.stream().map(batch -> {
            Entrollement entrollement = new Entrollement();
            entrollement.setEnrolledDate(LocalDate.now());
            entrollement.setStudent(student);
            entrollement.setBatch(batch);
            return entrollmentRepository.save(entrollement);
        }).collect(Collectors.toList());

        return entrollments;
    }

    // get all entrollments
    public List<Entrollement> getAllEntrollments() {
        return entrollmentRepository.findAll();
    }

    // get all entrollments by student id
    public List<EntrollmentResponseDTO> getAllEntrollmentsByStudentId(Long id) {
        List<Entrollement> entrollments = entrollmentRepository.findByStudentId(id);
        return entrollments.stream()
            .map(entrollment -> new EntrollmentResponseDTO(
                entrollment.getStudent().getId(),
                entrollment.getBatch().getId()
            ))
            .collect(Collectors.toList());
    }

    // update entrollment
    @Transactional
    public List<Entrollement> updateEntrollment(Long studentId, CreateEntrollmentDTO createEntrollmentDTO) {
        // Fetch student
        Student student = studentRepository.findById(studentId)
                .orElseThrow(() -> new IllegalArgumentException("Invalid student ID"));

        // Fetch batches to be added
        List<Batch> newBatches = batchRepository.findAllById(createEntrollmentDTO.getBatchIds());
        if (newBatches.isEmpty()) {
            throw new IllegalArgumentException("Invalid batch IDs");
        }

        // Get existing enrollments for this student
        List<Entrollement> existingEnrollments = entrollmentRepository.findByStudentId(studentId);
        List<Long> alreadyEnrolledBatchIds = existingEnrollments.stream()
                .map(enrollment -> enrollment.getBatch().getId())
                .collect(Collectors.toList());

        // Filter only new enrollments (excluding already enrolled batches)
        List<Entrollement> newEnrollments = newBatches.stream()
                .filter(batch -> !alreadyEnrolledBatchIds.contains(batch.getId()))
                .map(batch -> {
                    Entrollement entrollment = new Entrollement();
                    entrollment.setStudent(student);
                    entrollment.setBatch(batch);
                    entrollment.setEnrolledDate(LocalDate.now());
                    return entrollmentRepository.save(entrollment);
                }).collect(Collectors.toList());

        // Remove enrollments for batches that are no longer in the updated list
        List<Entrollement> enrollmentsToRemove = existingEnrollments.stream()
                .filter(enrollment -> !createEntrollmentDTO.getBatchIds().contains(enrollment.getBatch().getId()))
                .collect(Collectors.toList());

        entrollmentRepository.deleteAll(enrollmentsToRemove);

        return newEnrollments;
    }
}
