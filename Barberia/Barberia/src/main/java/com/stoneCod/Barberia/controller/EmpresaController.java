package com.stoneCod.Barberia.controller;

import com.stoneCod.Barberia.model.Empresa;
import com.stoneCod.Barberia.repository.EmpresaRepository;
import com.stoneCod.Barberia.service.EmpresaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


import java.util.*;

@Controller
public class EmpresaController {

    @Autowired
    EmpresaService empresaService;

   @GetMapping("/empresa")
    private String verEmpresa(Model model){
       model.addAttribute("empresas", empresaService.verEmpresa());
       return "empresa";
    }

    @GetMapping("/agregar_empresa")
    private String verFormEmpresa(Empresa empresa){
      return "agregar_empresa";
    }

    @PostMapping("/empresa")
    private String crearEmpresa(Empresa empresa){
        empresaService.crearYActualizarEmpresa(empresa);
        return "redirect:/empresa";
    }

    @GetMapping("/empresa/borrar/{id}")
    private String eliminarEmpresa(@PathVariable("id") Long id){
        empresaService.eliminarEmpresa(id);
        return "redirect:/empresa";
    }


    @GetMapping("/empresa/editar/{id}")
    private String verEmpresaPorId(@PathVariable("id") Long id, Model model){
        Empresa empresa = empresaService.verEmpresaId(id);
       model.addAttribute("empresa", empresa);
       return "actualizar_empresa";
    }

    @PostMapping("/empresa/actualizar/{id}")
    private String editarPEmpresa(@PathVariable("id") Long id, Empresa empresa){
        empresaService.crearYActualizarEmpresa(empresa);
        return "redirect:/empresa";
    }
}
