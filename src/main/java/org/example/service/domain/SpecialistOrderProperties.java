package org.example.service.domain;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
public class SpecialistOrderProperties {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "creattion-date")
    private LocalDate creationDate;

    @Column(name = "suggested-cost")
    private BigDecimal suggestedCost;

    @OneToOne
    private Specialist specialist;

    @Lob
    private String description;
}
