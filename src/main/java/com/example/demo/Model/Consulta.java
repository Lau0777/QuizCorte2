package com.example.demo.Model;


import jakarta.persistence.*;
import jdk.jfr.Enabled;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
@Entity
@Table(name = "consulta")
public class Consulta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private int id;


    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date fechaConsulta;

    private String motivo;

    private String diagnostico;

    @ManyToOne
    @JoinColumn(name = "mascota_id")
    private Mascota mascota;

    @ManyToOne
    @JoinColumn(name = "veterinario_id")
    private Veterinario veterinario;




}
