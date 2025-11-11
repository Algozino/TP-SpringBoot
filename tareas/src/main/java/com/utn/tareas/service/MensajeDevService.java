package com.utn.tareas.service;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile("dev") // Este bean solo se crea si el perfil "dev" está activo

public class MensajeDevService implements MensajeService {

    @Override
    public String mostrarBienvenida() {
        return "== BIENVENIDO AL MODO DESARROLLO (DEV) == \nIniciando gestor de tareas detallado...";
    }

    @Override
    public String mostrarDespedida() {
        return "== CERRANDO MODO DEV == \nGracias por codear!";
    }
}
