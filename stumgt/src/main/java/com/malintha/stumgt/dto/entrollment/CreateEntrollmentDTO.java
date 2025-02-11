package com.malintha.stumgt.dto.entrollment;

import java.time.LocalDate;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateEntrollmentDTO {
    private LocalDate enrolledDate;
    private Long studentId;
    private List<Long> batchIds;
}
