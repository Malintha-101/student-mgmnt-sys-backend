package com.malintha.stumgt.model;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "entrollements")
public class Entrollement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private LocalDate enrolledDate;

    // many entrollments refer to one student
    @ManyToOne
    @JoinColumn(name = "student_id")
    private Student student;

    // many entrollments refer to one batch
    @ManyToOne
    @JoinColumn(name = "batch_id")
    private Batch batch;
}
