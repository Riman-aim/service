package org.example.service.domain;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id ;

    @OneToOne
    private Specialist specialist;

    @OneToOne
    private Customer customer;

    @Lob
    private String comment;
}
