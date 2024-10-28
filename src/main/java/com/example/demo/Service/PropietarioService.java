package com.example.demo.Service;

import com.example.demo.InterfaceService.IPropietarioService;
import com.example.demo.Model.Propietario;
import com.example.demo.Repository.RPropietario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.amqp.RabbitProperties;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PropietarioService implements IPropietarioService {

    @Autowired
    private RPropietario repositorio;

    @Override
    public List<Propietario> listar() {
        return repositorio.findAll();
    }

    @Override
    public void guardar(Propietario propietario) {
        repositorio.save(propietario);
    }

    @Override
    public Optional<Propietario> editar(int id) {
        return repositorio.findById(id);
    }

    @Override
    public void eliminar(int id) {
        repositorio.deleteById(id);
    }
}
