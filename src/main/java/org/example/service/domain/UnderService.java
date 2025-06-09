package org.example.service.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class UnderService {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String name;

    private BigDecimal basePrice;

    @Lob
    private String description;

    @ManyToOne(cascade = CascadeType.PERSIST)
    private Service service;
}
