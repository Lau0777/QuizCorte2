package com.example.demo.Service;

import com.example.demo.InterfaceService.IMascotasService;
import com.example.demo.Model.Mascotas;
import com.example.demo.Repository.RMascotas;
import jdk.jfr.consumer.RecordedMethod;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class MascotasService  implements IMascotasService {


    @Autowired
    private RMascotas repositorio;


    @Override
    public List<Mascotas> listar(){
        return repositorio.findAll();
    }

    @Override
    public  void guardar(Mascotas mascotas){
        repositorio.save(mascotas);
    }

    @Override
    public Optional<Mascotas> editar(int id){
        return repositorio.findById(id);
    }

    @Override
    public void eliminar(int id){
        repositorio.deleteById(id);
    }
}
