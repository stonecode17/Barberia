package com.stoneCod.Barberia.service;

import com.stoneCod.Barberia.model.Transaccion;
import com.stoneCod.Barberia.repository.TransaccionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class TransaccionService{

    @Autowired
    TransaccionRepository transaccionRepository;

    public void crearYActualizarTransaccion(Transaccion transaccion){
        transaccionRepository.save(transaccion);
    }

    public List<Transaccion> verTransaccion(){
        return transaccionRepository.findAll();
    }

    public Transaccion verTransaccionId(Long id){
        return transaccionRepository.findById(id).get();
    }

    public void eliminarTransaccion(Long id){
        transaccionRepository.deleteById(id);
    }

}
