package com.stoneCod.Barberia.model;

import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Transaccion {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    private String concepto;
    private double monto;
    //private Double subtotal = 0.0;
    //private Double total = 0.0;
    //private Date fecha;

    //private void set
}
