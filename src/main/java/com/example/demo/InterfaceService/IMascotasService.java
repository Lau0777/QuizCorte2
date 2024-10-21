package com.example.demo.InterfaceService;

import com.example.demo.Model.Mascotas;

import java.util.List;
import java.util.Optional;

public interface IMascotasService {

    List<Mascotas> listar();


    void guardar(Mascotas mascotas);

    Optional<Mascotas> editar(int id);

    void eliminar(int id);

}
