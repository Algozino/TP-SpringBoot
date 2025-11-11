package com.utn.tareas.model;

import lombok.Data;

@Data

public class Tarea {
    private Long id;
    private String descripcion;
    private boolean completada;
    private Prioridad prioridad;

    public Tarea(Long id, String descripcion, Prioridad prioridad) {
        this.id = id;
        this.descripcion = descripcion;
        this.prioridad = prioridad;
        this.completada = false; // Las tareas nuevas no están completadas
    }
}
