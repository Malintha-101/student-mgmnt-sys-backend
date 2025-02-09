package com.malintha.stumgt.dto.batch;

import lombok.Data;

@Data
public class UpdateBatchDTO {
    private Long id;
    private String name;
    private String startDate;
    private String endDate;
    private Long courseId;
}
