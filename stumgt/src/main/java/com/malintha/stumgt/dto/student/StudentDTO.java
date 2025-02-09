package com.malintha.stumgt.dto.student;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class StudentDTO {
    private Long id;
    private String name;
    private String email;
    private String address;
    private String dob;
    private String phone;
}
