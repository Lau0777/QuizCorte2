package com.example.demo.InterfaceService;

import com.example.demo.Model.Consulta;

import java.util.List;
import java.util.Optional;

public interface IConsultaService {

    public List<Consulta> listar();

    public void guardar(Consulta consulta);

    public Optional<Consulta> editar(int id);

    public void eliminar(int id);
}
