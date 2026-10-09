package com.EjercicioAyudantia.ISoft.service;

import com.EjercicioAyudantia.ISoft.dto.TareaRequestDTO;
import com.EjercicioAyudantia.ISoft.model.Tarea;
import com.EjercicioAyudantia.ISoft.repository.TareaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class TareaService {

    // --- Atributos ---
    private final TareaRepository tareaRepository;
    private final AtomicLong idCounter = new AtomicLong(1L);

    // --- Constructores ---
    public TareaService(TareaRepository tareaRepository) {
        this.tareaRepository = tareaRepository;
    }

    // --- Lógica de Negocio ---
    public Tarea crearTarea(TareaRequestDTO dto) {
        Tarea nuevaTarea = new Tarea(
                idCounter.getAndIncrement(),
                dto.getTitulo(),
                dto.getPrioridad(),
                dto.getFechaLimite()
        );
        return tareaRepository.save(nuevaTarea);
    }

    public List<Tarea> obtenerTareas(String prioridad, String titulo, String fechaLimite) {
        return tareaRepository.findAll().stream()
                .filter(t -> prioridad == null || prioridad.isEmpty() || t.getPrioridad().equalsIgnoreCase(prioridad))
                .filter(t -> titulo == null || titulo.isEmpty() || t.getTitulo().toLowerCase().contains(titulo.toLowerCase()))
                .filter(t -> fechaLimite == null || fechaLimite.isEmpty() || (t.getFechaLimite() != null && t.getFechaLimite().equals(fechaLimite)))
                .toList();
    }

    public Optional<Tarea> completarTarea(Long id) {
        Optional<Tarea> tareaOpt = tareaRepository.findById(id);
        tareaOpt.ifPresent(tarea -> tarea.setCompletada(true));
        return tareaOpt;
    }
}