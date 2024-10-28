package com.example.demo.Service;

import com.example.demo.InterfaceService.IVeterinarioService;
import com.example.demo.Model.Veterinario;
import com.example.demo.Repository.RVeterinario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VeterinarioService  implements IVeterinarioService {

    @Autowired
    private RVeterinario repositorio;


    @Override
    public List<Veterinario> listar(){

        return repositorio.findAll();
    }

    @Override
    public void guardar(Veterinario veterinario){

        repositorio.save(veterinario);
    }

    @Override
    public Optional<Veterinario> editar(int id){

        return  repositorio.findById(id);
    }

    @Override
    public void eliminar(int id){

        repositorio.deleteById(id);

    }
}
