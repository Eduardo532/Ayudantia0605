package com.EjercicioAyudantia.ISoft.dto;

public class TareaRequestDTO {

    // --- Atributos ---
    private String titulo;
    private String prioridad;
    private String fechaLimite;

    // --- Getters y Setters ---
    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getPrioridad() {
        return prioridad;
    }

    public void setPrioridad(String prioridad) {
        this.prioridad = prioridad;
    }

    public String getFechaLimite() {
        return fechaLimite;
    }

    public void setFechaLimite(String fechaLimite) {
        this.fechaLimite = fechaLimite;
    }
}