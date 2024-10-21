package com.example.demo.InterfaceService;

import com.example.demo.Model.Propietarios;
import com.fasterxml.jackson.databind.annotation.JsonAppend;

import java.util.List;
import java.util.Optional;

public interface IPropietariosService {

    public List<Propietarios> listar();

    public void guardar(Propietarios pro);

    public Optional<Propietarios> editar(int id);

    public void eliminar(int id);


}
