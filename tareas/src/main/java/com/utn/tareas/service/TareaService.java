package com.utn.tareas.service;

import com.utn.tareas.model.Prioridad;
import com.utn.tareas.model.Tarea;
import com.utn.tareas.repository.TareaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value; // Importante
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor

public class TareaService {

    private final TareaRepository tareaRepository;

    // Inyección de propiedades
    @Value("${app.nombre}")
    private String appNombre;

    @Value("${app.max-tareas}")
    private int maxTareas;

    @Value("${app.mostrar-estadisticas}")
    private boolean mostrarEstadisticas;

    // Modificamos agregarTarea para validar
    public Tarea agregarTarea(String descripcion, Prioridad prioridad) {
        if (tareaRepository.obtenerTodas().size() >= maxTareas) {
            // En una app real, lanzaríamos una excepción
            System.err.println("Error: Se ha alcanzado el límite máximo de tareas (" + maxTareas + ")");
            return null;
        }
        Tarea nuevaTarea = new Tarea(null, descripcion, prioridad);
        return tareaRepository.guardar(nuevaTarea);
    }

    // Listar todas las tareas
    public List<Tarea> listarTodas() {
        return tareaRepository.obtenerTodas();
    }

    // Listar solo las tareas pendientes
    public List<Tarea> listarPendientes() {
        return tareaRepository.obtenerTodas().stream()
                .filter(t -> !t.isCompletada())
                .collect(Collectors.toList());
    }

    // Listar solo las tareas completadas
    public List<Tarea> listarCompletadas() {
        return tareaRepository.obtenerTodas().stream()
                .filter(Tarea::isCompletada)
                .collect(Collectors.toList());
    }

    // Marcar una tarea como completada (recibe ID)
    public Optional<Tarea> marcarComoCompletada(Long id) {
        Optional<Tarea> tareaOpt = tareaRepository.buscarPorId(id);
        if (tareaOpt.isPresent()) {
            Tarea tarea = tareaOpt.get();
            if (!tarea.isCompletada()) {
                tarea.setCompletada(true);
                // No llamamos a guardar() porque trabajamos sobre la instancia en memoria
            }
        }
        return tareaOpt;
    }

    // Metodo para imprimir las propiedades
    public void imprimirConfiguracion() {
        System.out.println("---------- Configuración de la App ----------");
        System.out.println("Nombre: " + appNombre);
        System.out.println("Max Tareas: " + maxTareas);
        System.out.println("Mostrar Stats: " + mostrarEstadisticas);
        System.out.println("---------------------------------------------");
    }

    // Modificamos obtenerEstadisticas para usar la property
    public String obtenerEstadisticas() {
        if (!mostrarEstadisticas) {
            return "Estadísticas deshabilitadas.";
        }
        long total = listarTodas().size();
        long completadas = listarCompletadas().size();
        long pendientes = total - completadas;

        return String.format("Estadísticas: Total=%d, Completadas=%d, Pendientes=%d", total, completadas, pendientes);
    }
}


