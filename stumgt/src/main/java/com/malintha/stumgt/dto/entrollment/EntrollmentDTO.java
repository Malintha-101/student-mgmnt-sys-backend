package com.malintha.stumgt.dto.entrollment;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EntrollmentDTO {
    private Long id;
    private LocalDate enrolledDate;
    private Long studentId;
    private Long batchId;
}
