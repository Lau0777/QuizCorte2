package com.example.demo.Model;

import jakarta.persistence.*;
import lombok.Data;
import org.antlr.v4.runtime.misc.NotNull;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Data
@Entity
@Table(name = "mascota")
public class Mascota {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private int id;

    private String nombre;

    private String especie;

    private String raza;



    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date fechaNacimiento;

    @ManyToOne
    @JoinColumn(name = "propietario_id")
    private Propietario propietario;

    /* @OneToMany(mappedBy = "mascota")
    private List<Consulta> consulta;*/
}
