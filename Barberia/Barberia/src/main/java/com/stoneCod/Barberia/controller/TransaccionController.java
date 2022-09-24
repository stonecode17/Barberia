package com.stoneCod.Barberia.controller;

import com.stoneCod.Barberia.model.Transaccion;
import com.stoneCod.Barberia.service.TransaccionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
public class TransaccionController {

    @Autowired
    TransaccionService transaccionService;

    @GetMapping("/transaccion/get")
    private List<Transaccion> verTransaccion (){
        return transaccionService.verTransaccion();
    }

    @GetMapping("/transaccion/get/{id}")
    public Transaccion transaccion(@PathVariable("id") Long id){
        return this.transaccionService.verTransaccionId(id);
    }

    @PostMapping("/transaccion/post")
    private void crearTransaccion(@RequestBody Transaccion transaccion){
        transaccionService.crearYActualizarTransaccion(transaccion);
    }

    @DeleteMapping("/transaccion/{id}")
    private void eliminarTransaccion(@PathVariable("id") Long id){
        transaccionService.eliminarTransaccion(id);
    }

    @PatchMapping("/transaccion/{id}")
    public Transaccion actualizarTransaccion(@PathVariable("id") Long id, @RequestBody Transaccion transaccion){
        Transaccion transaccion1 = transaccionService.verTransaccionId(id);
        transaccion1.setConcepto (transaccion.getConcepto());
        transaccion1.setMonto(transaccion.getMonto());
        //transaccion1.setFechaActualizacion(transaccion.getFechaActualizacion());
        //transaccion1.setFechaCreate(transaccion.getFechaCreate());
        return transaccionService.crearYActualizarTransaccion(transaccion1);
    }
}
