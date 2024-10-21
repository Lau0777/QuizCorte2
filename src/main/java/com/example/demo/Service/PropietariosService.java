package com.example.demo.Service;

import com.example.demo.InterfaceService.IPropietariosService;
import com.example.demo.Model.Propietarios;
import com.example.demo.Repository.RPropietarios;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class PropietariosService implements IPropietariosService {


    @Autowired
    private RPropietarios repositorio;


    @Override
    public List<Propietarios> listar(){
        return repositorio.findAll();
    }

    @Override
    public void guardar(Propietarios pro){
        repositorio.save(pro);
    }

    @Override
    public Optional<Propietarios> editar(int id){
        return repositorio.findById(id);
    }

    @Override
    public void eliminar(int id){
        repositorio.deleteById(id);
    }
}
