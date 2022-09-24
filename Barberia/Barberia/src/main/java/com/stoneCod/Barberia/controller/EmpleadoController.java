package com.stoneCod.Barberia.controller;

import com.stoneCod.Barberia.model.Empleado;
import com.stoneCod.Barberia.model.Empresa;
import com.stoneCod.Barberia.service.EmpleadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmpleadoController {

    @Autowired
    EmpleadoService empleadoService;

    @GetMapping("/empleado/get")
    private List<Empleado> verEmpleado(){
        return empleadoService.verEmpleado();
    }

    @PostMapping("/empleado/post")
    private void crearEmpleado(@RequestBody Empleado empleado){
        empleadoService.crearYActualizarEmpleado(empleado);
    }

    @DeleteMapping("/empleado/{id}")
    private void eliminarEmpleado(@PathVariable("id") Long id){
        empleadoService.eliminarEmpleado(id);
    }

    @PutMapping("/empleado/put")
    private void editarEmpleado(@RequestBody Empleado empleado){
        empleadoService.crearYActualizarEmpleado(empleado);
    }

}
