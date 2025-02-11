package com.malintha.stumgt.dto.student;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class StudentDTO {
    private Long id;
    private String name;
    private String email;
    private String address;
    private LocalDate dob;
    private String phone;
}
