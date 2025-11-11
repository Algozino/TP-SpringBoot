package com.utn.tareas.service;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile("prod") // Este bean solo se crea si el perfil 'prod' está activo

public class MensajeProdService implements MensajeService {

    @Override
    public String mostrarBienvenida() {
        return "Iniciando Gestor de Tareas (Producción)";
    }

    @Override
    public String mostrarDespedida() {
        return "Cerrando aplicación.";
    }
}
