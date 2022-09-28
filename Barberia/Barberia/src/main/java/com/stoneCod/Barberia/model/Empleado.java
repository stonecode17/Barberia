package com.stoneCod.Barberia.model;

import lombok.*;
import javax.persistence.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Table(name = "empleado")
public class Empleado {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "nombreEmpleado", nullable = false, unique = true, length = 50)
    private String nombreEmpleado;

    @Column(name = "correoEmpleado", nullable = false,  length = 50)
    private String correoEmpleado;

//    @Column(name = "empresaEmpleado", nullable = false,  length = 50)
//    private String empresaEmpleado;

    @Column(name = "rolEmpleado", nullable = false,  length = 50)
    private String rolEmpleado;

    @ManyToOne
    private Empresa empresa;
}
