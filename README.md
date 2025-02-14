# Taller 3 - Servidor Web y Framework IoC en Java

## Descripción
Este proyecto implementa un servidor web en Java sin el uso de frameworks como Apache, Spark o Spring. El servidor es capaz de:
- Servir páginas HTML y archivos PNG.
- Implementar un microframework IoC para construir aplicaciones web basadas en POJOs.
- Soportar anotaciones como `@RestController`, `@GetMapping` y `@RequestParam`.
- Explorar el classpath y registrar automáticamente los componentes anotados.
- Atender múltiples solicitudes secuenciales (no concurrentes).

El proyecto incluye una aplicación web de demostración que utiliza el servidor y el framework IoC.

---

## Características principales
- **Servidor HTTP en Java puro** con manejo de peticiones y respuestas.
- **Exploración dinámica de POJOs** usando reflexión para registrar controladores.
- **Anotaciones `@RestController` y `@GetMapping`** para definir endpoints.
- **Soporte para `@RequestParam`** para manejar parámetros de consulta en las peticiones.
- **Aplicación de ejemplo** con un servicio de saludo que demuestra la funcionalidad.
- **Manejo de rutas dinámicas y carga de archivos estáticos (HTML, CSS, PNG).**
- **Uso de Maven** para la gestión del ciclo de vida del proyecto.
- **Ejemplo de invocación con POJOs desde la línea de comandos.**

---

## Requisitos
Antes de ejecutar el proyecto, asegúrate de tener instalado:
- **Java 8+**
- **Maven**

Para verificar la instalación:
```sh
java -version
mvn -version
```

---

## Instalación y Ejecución
1. **Clonar el repositorio:**
    ```sh
    git clone https://github.com/Mauricio-A-Monroy/AREP-Taller-3
    cd AREP-Taller-3
    ```
2. **Compilar y ejecutar la aplicación con Maven:**
    ```sh
    mvn clean package
    java -cp target/classes edu.escuelaing.arep.microspring.MicroServer
    ```
3. **Abrir el navegador y probar los endpoints:**
    - `http://localhost:35000/` → Página principal.
    - `http://localhost:35000/greeting?name=Alejandro` → Devuelve "Hola, Alejandro".

---

## Estructura del Proyecto
```
+---src
|   +---main
|   |   +---java
|   |   |   \---edu
|   |   |       \---escuelaing
|   |   |           \---arep
|   |   |               \---microspring
|   |   |                   |   MicroServer.java
|   |   |                   |
|   |   |                   +---annotation
|   |   |                   |       GetMapping.java
|   |   |                   |       RequestParam.java
|   |   |                   |       RestController.java
|   |   |                   |
|   |   |                   +---controller
|   |   |                   |       GreetingController.java
|   |   |                   |       MathController.java
|   |   |                   |
|   |   |                   \---http
|   |   |                           HttpRequest.java
|   |   |                           HttpResponse.java
|   |   |                           HttpServer.java
|   |   |                           ServiceHandler.java
|   |   |
|   |   \---resources
|   |       \---static
|   |           |   index.html
|   |           |   IndexStyles.css
|   |           |   Pwelcome.jpeg
|   |           |
|   |           \---webApp
|   |                   App.html
|   |                   AppStyles.css
|   |
|   \---test
|       \---java
|           \---edu
|               \---escuelaing
|                   \---arep
|                       \---app
|                               AppTest.java
```

---

## Endpoints Disponibles
### **Páginas Web**
- `/` → Página principal (`index.html`).

### **Servicios REST**
- `/greeting?name=Alejandro` → Devuelve "Hola, Alejandro".
- `/pi` → Devuelve el valor de π.
- `/e` → Devuelve el valor de e.

Ejemplo de respuesta JSON:
```json
{"response":"Hola, Alejandro"}
```

---

## Pruebas automatizadas
Este proyecto incluye pruebas unitarias para verificar el correcto funcionamiento del servidor y los controladores. Para ejecutar las pruebas:
```sh
mvn test
```
Prueba de funcionamiento de las pruebas automatizadas
![image](https://github.com/user-attachments/assets/dc0a5dd9-d6c6-4d75-99ee-7caea9de8d38)


---

## Pruebas de Usuario
![image](https://github.com/user-attachments/assets/7deb077b-883b-4a72-a65a-aa73367d7f29)


![image](https://github.com/user-attachments/assets/304f4646-4794-4b86-868f-76f26b02d8eb)


![image](https://github.com/user-attachments/assets/399cebb9-9b28-4b9d-b1ab-1b5b19c1359b)


![image](https://github.com/user-attachments/assets/22a3d789-6ac7-4440-842b-f9d6a8762868)


![image](https://github.com/user-attachments/assets/bbd146e1-bec1-4d23-9194-d76c6c9ea900)


![image](https://github.com/user-attachments/assets/5039fb25-be48-413a-8c5c-8c0298799bb4)


![image](https://github.com/user-attachments/assets/d073c111-d522-458b-81f4-302ec0b57607)


---

## Tecnologías utilizadas
- **Java 8+** (Servidor y Framework IoC).
- **Maven** (Manejo de dependencias y construcción del proyecto).
- **JUnit** (Pruebas automatizadas).
- **HTML, CSS** (Para la aplicación web de demostración).

---

## Autores
- **Mauricio Alejandro Monroy Jiménez** - Desarrollo e implementación.
---

## Agradecimientos
Agradecimiento especial al profesor por su apoyo y guía en el desarrollo del proyecto.

