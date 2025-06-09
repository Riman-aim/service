package org.example.service.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "order-table")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @OneToOne
    private CustomerOrderProperties customerOrderProperties ;

    @OneToMany
    private List<SpecialistOrderProperties> specialistOrderProperties ;

    @OneToOne
    private UnderService underService ;
}
