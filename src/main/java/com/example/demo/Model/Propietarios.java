package com.example.demo.Model;


import jakarta.persistence.*;
import lombok.Data;


@Data
@Entity
@Table(name = "propietarios")
public class Propietarios {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private int idPro;

    private String nombre;

    private String direccion;

    private String telefono;
}
