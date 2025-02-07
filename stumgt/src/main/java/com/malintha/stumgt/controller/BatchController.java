package com.malintha.stumgt.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.malintha.stumgt.model.Batch;
import com.malintha.stumgt.service.BatchService;

@RestController
@RequestMapping("/api/batches")
public class BatchController {
    
    @Autowired
    private BatchService batchService;

    // create batch
    @PostMapping("/create")
    public Batch createBatch(@RequestBody Batch batch) {
        return batchService.createBatch(batch);
    }

    // get all batches
    @PostMapping("/all")
    public List<Batch> getAllBatches(){
        return batchService.getAllBatches();
    }

    // get batch by id
    @GetMapping("/get/{id}")
    public Batch getBatchById(@PathVariable Long id) {
        return batchService.getBatchById(id);
    }

    // update batch
    @PutMapping("/update/{id}")
    public Batch updateBatch(@RequestBody Batch batch, @PathVariable Long id) {
        return batchService.updateBatch(batch);
    }

    // delete batch
    @DeleteMapping("/delete/{id}")
    public void deleteBatch(@PathVariable Long id) {
        batchService.deleteBatch(id);
    }
    
}
