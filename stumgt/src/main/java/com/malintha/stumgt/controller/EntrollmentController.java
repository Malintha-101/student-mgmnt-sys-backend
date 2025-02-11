package com.malintha.stumgt.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.malintha.stumgt.dto.entrollment.CreateEntrollmentDTO;
import com.malintha.stumgt.dto.entrollment.EntrollmentResponseDTO;
import com.malintha.stumgt.model.Entrollement;
import com.malintha.stumgt.service.EntrollmentService;

@RestController
@RequestMapping("/api/entrollments")
public class EntrollmentController {
    
    @Autowired
    private EntrollmentService entrollmentService;

    // create entrollments for a student with multiple batch IDs
    @PostMapping("/create")
    public List<Entrollement> createEntrollments(@RequestBody CreateEntrollmentDTO createEntrollmentDTO) {
        return entrollmentService.createEntrollments(createEntrollmentDTO);
    }

    // get all entrollments
    @GetMapping("/all")
    public List<Entrollement> getAllEntrollments() {
        return entrollmentService.getAllEntrollments();
    }

    // get all entrollments by student id
    @GetMapping("/student/{id}")
    public List<EntrollmentResponseDTO> getAllEntrollmentsByStudentId(@PathVariable Long id) {
        return entrollmentService.getAllEntrollmentsByStudentId(id);
    }

    // update entrollment
    @PutMapping("/update/{id}")
    public ResponseEntity<List<Entrollement>> updateEntrollment(
            @PathVariable Long id, 
            @RequestBody CreateEntrollmentDTO createEntrollmentDTO) {
        
        List<Entrollement> updatedEntrollments = entrollmentService.updateEntrollment(id, createEntrollmentDTO);
        return ResponseEntity.ok(updatedEntrollments);
    }
}
