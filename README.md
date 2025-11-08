# TP Fundamentos de Spring Boot - Gestor de Tareas
### **Nombre:** Juan Ignacio Algozino

### **Legajo:** 49462

Este proyecto es una aplicación de consola para la gestión de tareas desarrollada con Spring Boot. Es el Trabajo Práctico de la materia **Desarrollo de software** de la **UTN FRM**.

El objetivo es aplicar conceptos fundamentales de Spring Boot como Inyección de Dependencias, Estereotipos, Configuración con `.properties` y gestión de Entornos con Profiles.

## 🛠️ Tecnologías Utilizadas
* **Java 17**
* **Spring Boot 3.x**
* **Maven**
* **Lombok**

## 🚀 Cómo Clonar y Ejecutar el Proyecto 

1.  Clona este repositorio:
    ```bash
    git clone https://github.com/Algozino/TP-SpringBoot.git
    ```
2.  Navega al directorio del proyecto:
    ```bash
    cd tareas
    ```
3.  Ejecuta el proyecto usando el wrapper de Maven:
    ```bash
    ./mvnw spring-boot:run
    ```
    (O usa `mvnw.cmd spring-boot:run` en Windows)

## 🔄 Gestión de Profiles (Entornos) 

La aplicación utiliza perfiles de Spring para gestionar diferentes configuraciones (`dev` y `prod`).

Por defecto, la aplicación se ejecuta con el perfil `dev`.

**Para cambiar al perfil `prod`:**

Puedes hacerlo de dos maneras:

1.  **Editando `application.properties`:**
    Cambia `spring.profiles.active=dev` a `spring.profiles.active=prod`.

2.  **Mediante un argumento de línea de comandos (Recomendado):**
    Ejecuta la aplicación pasando el perfil como argumento. Esto no modifica los archivos del proyecto.
    ```bash
    ./mvnw spring-boot:run -Dspring-boot.run.profiles=prod
    ```

## 📸 Capturas de Pantalla de Ejecución

Aquí debes pegar las capturas de pantalla de la consola para ambos perfiles.

### Ejecución con Perfil `dev` (default)

*(Pega tu captura de pantalla de la consola aquí)*
*Se observan los mensajes detallados de bienvenida/despedida.*
*El límite de tareas es 10.*
*Las estadísticas se muestran.*

### Ejecución con Perfil `prod`

*(Pega tu captura de pantalla de la consola aquí)*
*Se observan los mensajes concisos de producción.*
*El límite de tareas es 1000.*
*Las estadísticas indican "Estadísticas deshabilitadas."*

## 💭 Conclusiones Personales

Destaco la facilidad de la inyección de dependencias, cómo los perfiles permiten separar configuraciones, y la utilidad de Lombok para reducir código repetitivo.
