# Talycap-Global-LogisticsManagementBACKEND
![image](https://github.com/JhonHeiler/Talycap-Global-LogisticsManagementBACKEND/assets/89054795/409c23d0-75be-4637-96f8-d9d81b7dc5b6)

Desarrolle la aplicación con Spring Boot, JPA, MySQL, clean architecture y Angular:

1. Diseño y planificación:
   - Analiza los requisitos del enunciado y define los modelos de datos necesarios.
   - Crea el diagrama Entidad-Relación (E-R) para representar las relaciones entre las entidades de la aplicación.
   - Define las rutas y servicios que serán necesarios en la API RESTful.

2. Configuración del entorno:
   - Asegúrate de tener instalado Java Development Kit (JDK) en tu máquina.
   - Configura el entorno de desarrollo integrado en IntelliJ IDEA .
   - Instala Node.js y Angular CLI para la parte de frontend.

3. Creación del proyecto de backend:
   - Crea un nuevo proyecto de Spring Boot utilizando Spring Initializr (https://start.spring.io/) con las dependencias necesarias, como Spring Web, Spring Data JPA y MySQL Driver.
   - Configura la conexión a la base de datos MySQL en el archivo de configuración de Spring Boot (application.properties).

4. Definición de entidades y repositorios:
   - Crea las clases de entidad correspondientes a los modelos de datos definidos en el paso 1.
   - Define los repositorios JPA para realizar las operaciones de persistencia en la base de datos.

5. Implementación de servicios y controladores:
   - Crea los servicios que manejarán la lógica de negocio de la aplicación, como la creación de envíos y consultas.
   - Implementa los controladores RESTful para exponer los endpoints necesarios y manejar las solicitudes HTTP.

6. Validación de datos:
   - Implementa la validación de datos en los controladores utilizando anotaciones de validación de Spring, como @Valid.
   - Define las reglas de validación según los requisitos del enunciado y devuelve respuestas de error apropiadas (401, 422, 400) en caso de validación fallida.

7. Implementación de seguridad:
   - Añade seguridad a los servicios mediante tokens de tipo bearer con JWT.
   - Utiliza una biblioteca como Spring Security para la autenticación y autorización de usuarios.
   - Configura la validación del token en las solicitudes entrantes.

8. Persistencia de datos:
   - Utiliza JPA para mapear y persistir los datos en la base de datos MySQL.
   - Crea las tablas correspondientes a las entidades definidas en el diagrama E-R.
   - Realiza pruebas para asegurarte de que los datos se almacenen correctamente.

9. Pruebas unitarias:
   - Crea pruebas unitarias utilizando un framework de pruebas como JUnit y mockito.
   - Prueba las funcionalidades implementadas en el backend para garantizar la calidad del código.
   - Verifica que los casos de prueba cubran los diferentes escenarios y situaciones límite.

