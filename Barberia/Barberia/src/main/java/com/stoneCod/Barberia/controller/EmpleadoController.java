package com.stoneCod.Barberia.controller;

import com.stoneCod.Barberia.model.Empleado;
import com.stoneCod.Barberia.service.EmpleadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class EmpleadoController {

    @Autowired
    EmpleadoService empleadoService;

    @GetMapping("/empleado")
    private String verEmpleado(Model model){
        model.addAttribute("empleados", empleadoService.verEmpleado());
        return "empleado";
    }

    @GetMapping("/agregar_empleado")
    private String verFormEmpleado(Empleado empleado){
        return "agregar_empleado";
    }

    @PostMapping("/empleado")
    private String crearEmpleado(Empleado empleado){
        empleadoService.crearYActualizarEmpleado(empleado);
        return "redirect:/empleado";
    }

    @GetMapping("/empleado/borrar/{id}")
    private String eliminarEmpleado(@PathVariable("id") Long id){
        empleadoService.eliminarEmpleado(id);
        return "redirect:/empleado";
    }


    @GetMapping("/empleado/editar/{id}")
    private String verEmpleadoPorId(@PathVariable("id") Long id, Model model){
        Empleado empleado = empleadoService.verEmpleadoId(id);
        model.addAttribute("empleado", empleado);
        return "actualizar_empleado";
    }

    @PostMapping("/empleado/actualizar/{id}")
    private String editarPEmpleado(@PathVariable("id") Long id, Empleado empleado){
        empleadoService.crearYActualizarEmpleado(empleado);
        return "redirect:/empleado";
    }
}