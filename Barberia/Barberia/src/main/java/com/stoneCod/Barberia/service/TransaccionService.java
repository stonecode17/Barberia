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

    public Transaccion crearYActualizarTransaccion(Transaccion transaccion){
        Transaccion transaccion1 = transaccionRepository.save(transaccion);
        return transaccion1;
    }

    public List<Transaccion> verTransaccion(){
        List<Transaccion> transaccions = new ArrayList<Transaccion>();
        transaccions.addAll(transaccionRepository.findAll());
        return transaccions;
    }

    public Transaccion verTransaccionId(Long id){
        return transaccionRepository.findById(id).get();
    }

    public void eliminarTransaccion(Long id){
        transaccionRepository.deleteById(id);
    }

}
