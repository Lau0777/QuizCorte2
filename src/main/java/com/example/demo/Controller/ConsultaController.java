package com.example.demo.Controller;


import com.example.demo.InterfaceService.IConsultaService;
import com.example.demo.InterfaceService.IMascotaService;
import com.example.demo.InterfaceService.IPropietarioService;
import com.example.demo.InterfaceService.IVeterinarioService;
import com.example.demo.Model.Consulta;
import com.example.demo.Model.Mascota;
import com.example.demo.Model.Propietario;
import com.example.demo.Model.Veterinario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/consultas")
public class ConsultaController {

    @Autowired
    private IConsultaService service;

    @Autowired
    private IMascotaService mascotaService;

    @Autowired
    private IVeterinarioService veterinarioService;

    @GetMapping
    public String listarConsultas(Model model) {
        model.addAttribute("titulo", "Consultas");
        model.addAttribute("cuerpo", "Lista de Consultas");
        model.addAttribute("datos", service.listar());
        return "consultas";
    }

    @GetMapping("/nuevo")
    public String formAgregarConsulta(Model model) {
        model.addAttribute("titulo", "Nueva Consulta");
        model.addAttribute("cuerpo", "Agregar Nueva Consulta");
        model.addAttribute("consulta", new Consulta());

        // Asegúrate de que la lista de mascotas no esté vacía
        List<Mascota> mascotas = mascotaService.listar();
        model.addAttribute("mascotas", mascotas);

        // Asegúrate de que la lista de veterinarios no esté vacía
        List<Veterinario> veterinarios = veterinarioService.listar();
        model.addAttribute("veterinarios", veterinarios);

        return "nuevaConsulta";
    }

    @PostMapping("/guardar")
    public String guardarConsulta(@ModelAttribute Consulta consulta) {
        service.guardar(consulta);
        return "redirect:/consultas";
    }

    @GetMapping("/editar/{id}")
    public String editarConsulta(@PathVariable("id") int id, Model model) {
        Optional<Consulta> consulta = service.editar(id);
        model.addAttribute("consulta", consulta.orElse(new Consulta()));
        model.addAttribute("mascotas", mascotaService.listar());
        model.addAttribute("veterinarios", veterinarioService.listar());
        return "nuevaConsulta";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminarConsulta(@PathVariable("id") int id) {
        service.eliminar(id);
        return "redirect:/consultas";
    }

}
