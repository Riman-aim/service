package org.example.service.domain;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Wallet {
    @Id
    private int id ;

    private BigDecimal amount ;

    @Column(unique=true)
    private String cardNumber ;

    private String cvv2 ;

    private LocalDate expiryDate ;

    private String password ;



}
