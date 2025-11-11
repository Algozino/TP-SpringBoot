package com.utn.tareas.repository;

import com.utn.tareas.model.Prioridad;
import com.utn.tareas.model.Tarea;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

@Repository

public class TareaRepository {

    private final List<Tarea> tareas = new ArrayList<>();
    private final AtomicLong contadorId = new AtomicLong(1); // Para IDs automáticos

    // Constructor para inicializar con tareas de ejemplo
    public TareaRepository() {
        guardar(new Tarea(contadorId.getAndIncrement(), "Estudiar Spring Boot", Prioridad.ALTA));
        guardar(new Tarea(contadorId.getAndIncrement(), "Hacer el Trabajo Práctico", Prioridad.ALTA));
        guardar(new Tarea(contadorId.getAndIncrement(), "Comprar pan", Prioridad.MEDIA));
        guardar(new Tarea(contadorId.getAndIncrement(), "Ver serie", Prioridad.BAJA));
    }

    // Metodo para guardar una tarea (con ID automático)
    public Tarea guardar(Tarea tarea) {
        if (tarea.getId() == null) {
            tarea.setId(contadorId.getAndIncrement());
        }
        tareas.add(tarea);
        return tarea;
    }

    // Obtener todas las tareas
    public List<Tarea> obtenerTodas() {
        return new ArrayList<>(tareas); // Devuelve una copia
    }

    // Buscar por ID
    public Optional<Tarea> buscarPorId(Long id) {
        return tareas.stream()
                .filter(t -> t.getId().equals(id))
                .findFirst();
    }

    // Eliminar por ID
    public boolean eliminarPorId(Long id) {
        return tareas.removeIf(t -> t.getId().equals(id));
    }
}
