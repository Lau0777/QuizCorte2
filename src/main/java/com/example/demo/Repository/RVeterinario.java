package com.example.demo.Repository;

import com.example.demo.Model.Veterinario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RVeterinario extends JpaRepository<Veterinario, Integer> {
}
