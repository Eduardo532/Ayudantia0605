package com.EjercicioAyudantia.ISoft.controller;

import com.EjercicioAyudantia.ISoft.dto.TareaRequestDTO;
import com.EjercicioAyudantia.ISoft.model.Tarea;
import com.EjercicioAyudantia.ISoft.service.TareaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TareaController {

    // --- Dependencias ---
    private final TareaService tareaService;

    public TareaController(TareaService tareaService) {
        this.tareaService = tareaService;
    }

    // --- Endpoints ---
    @PostMapping
    public ResponseEntity<Tarea> crearTarea(@RequestBody TareaRequestDTO dto) {
        Tarea nuevaTarea = tareaService.crearTarea(dto);
        return ResponseEntity.status(201).body(nuevaTarea);
    }

    @GetMapping
    public ResponseEntity<List<Tarea>> obtenerTareas(
            @RequestParam(required = false) String prioridad,
            @RequestParam(required = false) String titulo,
            @RequestParam(required = false) String fechaLimite) {

        List<Tarea> tareas = tareaService.obtenerTareas(prioridad, titulo, fechaLimite);
        return ResponseEntity.ok(tareas);
    }

    @PatchMapping("/{id}/complete")
    public ResponseEntity<Tarea> completarTarea(@PathVariable Long id) {
        return tareaService.completarTarea(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
}