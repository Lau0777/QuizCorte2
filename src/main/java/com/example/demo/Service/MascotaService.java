package com.example.demo.Service;

import com.example.demo.InterfaceService.IMascotaService;
import com.example.demo.Model.Mascota;
import com.example.demo.Model.Propietario;
import com.example.demo.Repository.RMascota;
import com.example.demo.Repository.RPropietario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MascotaService  implements IMascotaService {

    @Autowired
    private RMascota repositorio;

    @Autowired
    private RPropietario propietarioRepositorio;

    @Override
    public List<Mascota> listar() {
        return repositorio.findAll();
    }

    @Override
    public void guardar(Mascota mascota) {
        repositorio.save(mascota);
    }

    @Override
    public Optional<Mascota> editar(int id) {
        return repositorio.findById(id);
    }

    @Override
    public void eliminar(int id) {
        repositorio.deleteById(id);
    }

    @Override
    public List<Propietario> listarPropietarios() {
        return propietarioRepositorio.findAll();
    }

}
