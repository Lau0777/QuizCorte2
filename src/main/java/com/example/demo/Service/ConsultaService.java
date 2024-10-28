package com.example.demo.Service;

import com.example.demo.InterfaceService.IConsultaService;
import com.example.demo.Model.Consulta;
import com.example.demo.Repository.RConsulta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ConsultaService implements IConsultaService {

    @Autowired
    private RConsulta repositorio;


    @Override
    public List<Consulta> listar(){
        return repositorio.findAll();
    }

    @Override
    public void guardar(Consulta consulta){

        repositorio.save(consulta);
    }

    @Override
    public Optional<Consulta> editar(int id){
        return repositorio.findById(id);
    }

    @Override
    public void eliminar(int id) {
        repositorio.deleteById(id);
    }
}
