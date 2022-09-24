package com.stoneCod.Barberia.service;

import com.stoneCod.Barberia.model.Empresa;
import com.stoneCod.Barberia.repository.EmpresaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class EmpresaService {

    @Autowired
    EmpresaRepository empresaRepository;

    public Empresa crearYActualizarEmpresa(Empresa empresa){
        Empresa empresa1 = empresaRepository.save(empresa);
        return empresa1;
    }

    public List<Empresa> verEmpresa(){
        List<Empresa> empresas = new ArrayList<Empresa>();
        empresas.addAll(empresaRepository.findAll());
        return empresas;
    }

    public Empresa verEmpresaId(Long id){
        return empresaRepository.findById(id).get();
    }

    public void eliminarEmpresa(Long id){
        empresaRepository.deleteById(id);
    }

}
