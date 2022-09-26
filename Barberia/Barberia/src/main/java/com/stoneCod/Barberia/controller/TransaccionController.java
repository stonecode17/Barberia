package com.stoneCod.Barberia.controller;

import com.stoneCod.Barberia.model.Transaccion;
import com.stoneCod.Barberia.service.TransaccionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;

import java.util.*;

@Controller
public class TransaccionController {

    @Autowired
    TransaccionService transaccionService;

    @GetMapping("/transaccion")
    private String verTransaccion(Model model){
        model.addAttribute("transaccion", transaccionService.verTransaccion());
        return "transaccion";
    }

    @GetMapping("agregar_transaccion")
    private String verFormTransaccion(Transaccion transaccion){
        return "agregar_transaccion";
    }

    @PostMapping("/transaccion")
    private String crearTransaccion(Transaccion transaccion){
        transaccionService.crearYActualizarTransaccion(transaccion);
        return "redirect:/transaccion";
    }

    @GetMapping("/transaccion/borrar/{id}")
    private String eliminarTransaccion(@PathVariable("id") Long id){
        transaccionService.eliminarTransaccion(id);
        return "redirect:/transaccion";
    }


    @GetMapping("/transaccion/editar/{id}")
    private String verTransaccionPorId(@PathVariable("id") Long id, Model model){
        Transaccion transaccion = transaccionService.verTransaccionId(id);
        model.addAttribute("transaccion", transaccion);
        return "actualizar_transaccion";
    }

    @PostMapping("/transaccion/actualizar/{id}")
    private String editarPTransaccion(@PathVariable("id") Long id, Transaccion transaccion){
        transaccionService.crearYActualizarTransaccion(transaccion);
        return "redirect:/transaccion";
    }
}