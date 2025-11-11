package com.utn.tareas;

import com.utn.tareas.model.Prioridad;
import com.utn.tareas.service.MensajeService;
import com.utn.tareas.service.TareaService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@RequiredArgsConstructor

public class TareasApplication implements CommandLineRunner {

    // Inyección de dependencias por constructor
    private final TareaService tareaService;
    private final MensajeService mensajeService;

    public static void main(String[] args) {
        SpringApplication.run(TareasApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("=============================================");
        // Mostrar mensaje de bienvenida
        System.out.println(mensajeService.mostrarBienvenida());
        System.out.println("=============================================");

        // Mostrar la configuración actual
        tareaService.imprimirConfiguracion();

        // Listar todas las tareas iniciales
        System.out.println("\n[ TAREAS INICIALES ]");
        tareaService.listarTodas().forEach(System.out::println);

        // Agregar una nueva tarea
        System.out.println("\n[ AGREGANDO TAREA NUEVA ]");
        tareaService.agregarTarea("Terminar documentación", Prioridad.MEDIA);

        // Listar tareas pendientes
        System.out.println("\n[ TAREAS PENDIENTES ]");
        tareaService.listarPendientes().forEach(System.out::println);

        // Marcar una tarea como completada (ID 2, por ejemplo)
        System.out.println("\n[ COMPLETANDO TAREA ID=2 ]");
        tareaService.marcarComoCompletada(2L);

        // Mostrar estadísticas
        System.out.println("\n[ ESTADÍSTICAS ]");
        System.out.println(tareaService.obtenerEstadisticas());

        // 8. Listar tareas completadas
        System.out.println("\n[ TAREAS COMPLETADAS ]");
        tareaService.listarCompletadas().forEach(System.out::println);

        // 9. Mostrar mensaje de despedida
        System.out.println("\n=============================================");
        System.out.println(mensajeService.mostrarDespedida());
        System.out.println("=============================================");
    }
}
