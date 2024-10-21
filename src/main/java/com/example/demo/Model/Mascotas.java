package com.example.demo.Model;


import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name= "mascotas")
public class Mascotas {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private int idMascota;

    private String nombre;

    private String especie;

    private String raza;

    private String fechaNacimiento;



}
