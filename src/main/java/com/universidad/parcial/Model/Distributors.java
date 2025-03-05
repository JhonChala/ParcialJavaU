package com.universidad.parcial.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import static jakarta.persistence.GenerationType.SEQUENCE;

@Entity
@Table(name = "distributors")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Distributors {

    @Id
    @SequenceGenerator(
            name = "distributors_sequence",
            sequenceName = "distributors_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = SEQUENCE,
            generator = "distributors_sequence"
    )
    private long id;

    private String name;

    private String email;

    private String address;

    private String cellphone;

    private String company;

}
