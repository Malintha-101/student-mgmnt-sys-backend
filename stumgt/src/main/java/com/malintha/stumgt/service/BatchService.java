package com.malintha.stumgt.service;

import java.util.List;
import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.malintha.stumgt.dto.batch.BatchDTO;
import com.malintha.stumgt.dto.batch.UpdateBatchDTO;
import com.malintha.stumgt.model.Batch;
import com.malintha.stumgt.repository.BatchRepository;

@Service
public class BatchService {
    
    @Autowired
    private BatchRepository batchRepository;

    @Autowired
    private CourseService courseService;

    // create batch
    public Batch createBatch(Batch batch) {
        return batchRepository.save(batch);
    }

    // get all batches
    public List<BatchDTO> getAllBatches() {
        List<Batch> batches = batchRepository.findAll();
        return batches.stream().map(this::mapToBatchDTO).toList();
    }

    // get batch by id
    public Batch getBatchById(Long id) {
        return batchRepository.findById(id).orElse(null);
    }

    // update batch
    public BatchDTO updateBatch(UpdateBatchDTO updateBatchDTO) {
        Batch batch = batchRepository.findById(updateBatchDTO.getId()).orElse(null);
        if (batch == null) {
            return null;
        }
        batch.setName(updateBatchDTO.getName());
        batch.setStartDate(LocalDate.parse(updateBatchDTO.getStartDate()));
        batch.setEndDate(LocalDate.parse(updateBatchDTO.getEndDate()));
        batch.setCourse(courseService.getCourseById(updateBatchDTO.getCourseId()));
        batchRepository.save(batch);
        return mapToBatchDTO(batch);
        
    }

    // delete batch
    public void deleteBatch(Long id) {
        batchRepository.deleteById(id);
    }

    private BatchDTO mapToBatchDTO(Batch batch) {
        String courseName = courseService.getCourseById(batch.getCourse().getId()).getName();
        return new BatchDTO(
            batch.getId(), 
            batch.getName(), 
            batch.getStartDate(), 
            batch.getEndDate(), 
            batch.getCourse().getId(),
            courseName // Include course name
        );
    }
}
