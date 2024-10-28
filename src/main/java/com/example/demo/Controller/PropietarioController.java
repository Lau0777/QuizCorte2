package com.example.demo.Controller;


import com.example.demo.InterfaceService.IPropietarioService;
import com.example.demo.Model.Propietario;
import jakarta.persistence.GeneratedValue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping
public class PropietarioController {

    @Autowired
    private IPropietarioService service;

    @GetMapping("/propietarios")
    public String listarPropietarios(Model model) {
        model.addAttribute("titulo", "Propietarios");
        model.addAttribute("cuerpo", "Lista de Propietarios");
        model.addAttribute("datos", service.listar());
        return "propietarios";
    }

    @GetMapping("/propietarios/nuevo")
    public String formAgregarPropietario(Model model) {
        model.addAttribute("titulo", "Nuevo Propietario");
        model.addAttribute("cuerpo", "Agregar Nuevo Propietario");
        model.addAttribute("propietario", new Propietario());
        return "nuevoPropietario";
    }

    @PostMapping("/propietarios/guardar")
    public String guardarPropietario(@ModelAttribute Propietario propietario) {
        service.guardar(propietario);
        return "redirect:/propietarios";
    }

    @GetMapping("/propietarios/editar/{id}")
    public String editarPropietario(@PathVariable("id") int id, Model model) {
        Optional<Propietario> propietario = service.editar(id);
        model.addAttribute("propietario", propietario);
        return "nuevoPropietario";
    }

    @GetMapping("/propietarios/eliminar/{id}")
    public String eliminarPropietario(@PathVariable("id") int id) {
        service.eliminar(id);
        return "redirect:/propietarios";
    }


}
