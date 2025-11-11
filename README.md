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

### Ejecución con Perfil `dev` (default)

*<img width="2305" height="982" alt="image" src="https://github.com/user-attachments/assets/5abfdac0-32bb-4ae1-ae47-692975365d40" />*
*<img width="2292" height="659" alt="image" src="https://github.com/user-attachments/assets/6eca7091-544c-4e9e-ace8-bf779305e828" />*

*Se observan los mensajes detallados de bienvenida/despedida.*
*El límite de tareas es 10.*
*Las estadísticas se muestran.*

### Ejecución con Perfil `prod`

*<img width="2307" height="1040" alt="image" src="https://github.com/user-attachments/assets/ca431118-e021-424e-ba88-a6079a70a50d" />*
*<img width="2295" height="395" alt="image" src="https://github.com/user-attachments/assets/6d2d5490-8a5c-4c8a-b3db-789bb076d3ea" />*

*Se observan los mensajes concisos de producción.*
*El límite de tareas es 1000.*
*Las estadísticas indican "Estadísticas deshabilitadas."*

## 💭 Conclusiones Personales

Destaco la facilidad de la inyección de dependencias, cómo los perfiles permiten separar configuraciones, y la utilidad de Lombok para reducir código repetitivo.
