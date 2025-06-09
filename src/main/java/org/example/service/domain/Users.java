package org.example.service.domain;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import org.example.service.enumeration.AwaitingStatus;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@MappedSuperclass
@Getter
@Setter
@NoArgsConstructor
public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String firstname;

    private String lastname;

    @Column(unique = true)
    private String email;

    private String password;
//status
    private AwaitingStatus awaitingStatus;

    private LocalDate createdDate;

    @OneToOne
    private Wallet wallet;


}
