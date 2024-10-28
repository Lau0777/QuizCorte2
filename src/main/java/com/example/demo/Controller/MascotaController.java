package com.example.demo.Controller;

import com.example.demo.InterfaceService.IMascotaService;
import com.example.demo.InterfaceService.IPropietarioService;
import com.example.demo.Model.Mascota;
import com.example.demo.Model.Propietario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@Controller
@RequestMapping
public class MascotaController {

    @Autowired
    private IMascotaService service;

    @GetMapping("/mascotas")
    public String listarMascotas(Model model) {
        model.addAttribute("titulo", "Mascotas");
        model.addAttribute("cuerpo", "Lista de Mascotas");
        model.addAttribute("datos", service.listar());
        return "mascotas";
    }

    @GetMapping("mascotas/nuevo")
    public String formAgregarMascota(Model model) {
        model.addAttribute("titulo", "Nueva Mascota");
        model.addAttribute("cuerpo", "Agregar Nueva Mascota");
        model.addAttribute("mascota", new Mascota());
        model.addAttribute("propietarios", service.listarPropietarios()); // Fetch propietarios for selection
        return "nuevaMascota";
    }

    @PostMapping("mascotas/guardar")
    public String guardarMascota(@ModelAttribute Mascota mascota, BindingResult result) {
        if (result.hasErrors()) {
            return "error";
        }
        service.guardar(mascota);
        return "redirect:/mascotas";
    }

    @GetMapping("mascotas/editar/{id}")
    public String editarMascota(@PathVariable("id") int id, Model model) {
        Optional<Mascota> mascota = service.editar(id);
        model.addAttribute("mascota", mascota);
        model.addAttribute("propietarios", service.listarPropietarios()); // Fetch propietarios for selection
        return "nuevaMascota";
    }

    @GetMapping("mascotas/eliminar/{id}")
    public String eliminarMascota(@PathVariable("id") int id) {
        service.eliminar(id);
        return "redirect:/mascotas";
    }

}
