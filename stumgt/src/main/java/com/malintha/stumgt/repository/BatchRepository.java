package com.malintha.stumgt.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.malintha.stumgt.model.Batch;

@Repository
public interface BatchRepository extends JpaRepository<Batch, Long> {
}