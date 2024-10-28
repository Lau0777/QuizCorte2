package com.example.demo.Controller;


import com.example.demo.InterfaceService.IVeterinarioService;
import com.example.demo.Model.Veterinario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping("/veterinarios")
public class VeterinarioController {

    @Autowired
    private IVeterinarioService service;



    @GetMapping
    public String listarVeterinarios(Model model) {
        model.addAttribute("titulo", "Veterinarios");
        model.addAttribute("cuerpo", "Lista De Veterinarios");
        model.addAttribute("datos", service.listar());
        return "veterinarios";

    }


    @GetMapping("/nuevo")
    public String agregarVeterinario(Model model){
        model.addAttribute("titulo", "Nuevo Veterinario");
        model.addAttribute("cuerpo", "Agregar Nuevo Veterinario");
        model.addAttribute("veterinario", new Veterinario());
        return "nuevoVeterinario";
    }

    @PostMapping("/guardar")
    public String guardarVeterinario(@ModelAttribute Veterinario veterinario){
        service.guardar(veterinario);
        return "redirect:/veterinarios";
    }

    @GetMapping("/editar/{id}")
    public String editarVeterinario(@PathVariable("id") int id, Model model){
        Optional<Veterinario> veterinario = service.editar(id);
        model.addAttribute("veterinario", veterinario.orElse(new Veterinario()));
        return "nuevoVeterinario";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminarVeterinario(@PathVariable("id") int id){
        service.eliminar(id);
        return "redirect:/veterinarios";
    }

}
