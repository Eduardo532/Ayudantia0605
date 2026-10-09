package com.EjercicioAyudantia.ISoft.repository;

import com.EjercicioAyudantia.ISoft.model.Tarea;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class TareaRepository {

    // --- Atributos ---
    private final List<Tarea> tareas = new ArrayList<>();

    // --- Métodos de Acceso a Datos ---
    public Tarea save(Tarea tarea) {
        tareas.add(tarea);
        return tarea;
    }

    public List<Tarea> findAll() {
        return tareas;
    }

    public Optional<Tarea> findById(Long id) {
        return tareas.stream()
                .filter(t -> t.getId().equals(id))
                .findFirst();
    }
}