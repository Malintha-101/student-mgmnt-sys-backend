package com.malintha.stumgt.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.malintha.stumgt.model.Entrollement;

@Repository
public interface EntrollmentRepository extends JpaRepository<Entrollement, Long>{
    
}