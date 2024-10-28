package com.example.demo.InterfaceService;

import com.example.demo.Model.Mascota;
import com.example.demo.Model.Propietario;

import java.util.List;
import java.util.Optional;

public interface IMascotaService {


    List<Mascota> listar();

    void guardar(Mascota mascota);

    Optional<Mascota> editar(int id);

    void eliminar(int id);

    List<Propietario> listarPropietarios();
}
