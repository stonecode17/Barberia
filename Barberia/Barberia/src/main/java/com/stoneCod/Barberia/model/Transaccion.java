package com.stoneCod.Barberia.model;

import lombok.*;
import javax.persistence.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Table(name = "transaccion")
public class Transaccion {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "concepto", nullable = false,  length = 50)
    private String concepto;

    @Column(name = "monto", nullable = false)
    private double monto;
    //private Double subtotal = 0.0;
    //private Double total = 0.0;
    //private Date fecha;

    @ManyToOne
    private Empleado empleado;

    @ManyToOne
    private Empresa empresa;
}

