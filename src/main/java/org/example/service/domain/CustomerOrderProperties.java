package org.example.service.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class CustomerOrderProperties {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private BigDecimal cost;
//TODO work on it
    @Lob
    @Column(name = "work-description")
    private String workDescription;

    @Column(name = "target-time")
    private LocalDate targetTime;

    @OneToOne
    private Customer customer;




}
