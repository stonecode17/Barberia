package com.stoneCod.Barberia.service;

import com.stoneCod.Barberia.model.Empleado;
import com.stoneCod.Barberia.repository.EmpleadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class EmpleadoService {

    @Autowired
    EmpleadoRepository empleadoRepository;

    public void crearYActualizarEmpleado(Empleado empleado){
        empleadoRepository.save(empleado);
    }

    public List<Empleado> verEmpleado(){
        return empleadoRepository.findAll();
    }

    public Empleado verEmpleadoId(Long id){
        return empleadoRepository.findById(id).get();
    }
    public void eliminarEmpleado(Long id){
        empleadoRepository.deleteById(id);
    }

}
