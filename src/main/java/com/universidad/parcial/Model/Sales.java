package com.universidad.parcial.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import static jakarta.persistence.GenerationType.SEQUENCE;
@Entity
@Table(name = "sales")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Sales {

    @Id
    @SequenceGenerator(
            name = "sales_sequence",
            sequenceName = "sales_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = SEQUENCE,
            generator = "sales_sequence"
    )
    private long id;

    @ManyToOne
    @JoinColumn(name = "product_id", nullable = false)
    private Product nameProduct;

    private Float salePrice;

    @ManyToOne
    @JoinColumn(name = "client_id", nullable = false)
    private Client nameClient;

}
