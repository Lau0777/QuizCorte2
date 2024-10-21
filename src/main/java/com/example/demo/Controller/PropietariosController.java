package com.example.demo.Controller;

import com.example.demo.InterfaceService.IPropietariosService;
import com.example.demo.Model.Propietarios;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

public class PropietariosController {

    @Autowired
    private IPropietariosService service;

    @GetMapping("/listar")
    public String listarPropietarios(Model model){

        model.addAttribute("titulo", "Veterinaria");
        model.addAttribute("cuerpo", "LISTA DE PROPIETARIOS");

        model.addAttribute("datos", service.listar());
        return "index";


    }

    @GetMapping("/nuevoPro")
    public String agregarPropietarios(Model model){
        model.addAttribute("titulo", "Nuevo");
        model.addAttribute("cuerpo", "USUARIO NUEVO");

        model.addAttribute("pro",new Propietarios());
        return "nuevo";
    }
}
