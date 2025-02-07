package com.malintha.stumgt.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.malintha.stumgt.model.Batch;
import com.malintha.stumgt.repository.BatchRepository;

@Service
public class BatchService {
    
    @Autowired
    private BatchRepository batchRepository;

    // create batch
    public Batch createBatch(Batch batch) {
        return batchRepository.save(batch);
    }

    // get all batches
    public List<Batch> getAllBatches() {
        return batchRepository.findAll();
    }

    // get batch by id
    public Batch getBatchById(Long id) {
        return batchRepository.findById(id).orElse(null);
    }

    // update batch
    public Batch updateBatch(Batch batch) {
        return batchRepository.save(batch);
    }

    // delete batch
    public void deleteBatch(Long id) {
        batchRepository.deleteById(id);
    }
}
