# tienda-market
_______________________
# Herramientas utilizadas para crear el proyecto
- Java JDK Versión 11.0.13
-	IDE: IntelliJ IDEA Community Edition 2022.1.1
-	Base de Datos: PostgreSQL Versión 11.16
-	Pruebas Unitarias: Postman
-	Framework Spring: Spring Framework, Spring Boot, Spring Data JPA
-	Front-end: Angular Versión 9.0.7
_______________________
# Despliegue Producción
* Proyecto desplegado en ambiente de Producción (pdn) usando Heroku (Plataforma de servicios en la nube).
Ver: https://app-back-end-carrito.herokuapp.com/tienda-market/api
_______________________
# Despliegue Desarrollo
* Para desplegar el proyecto en ambiente de desarrollo, debemos seguir los siguientes pasos:

1) Descargar del repositorio GibHub el proyecto: tienda-market.

2) Crear la base datos tienda-market en postgresql y ejecutar los siguientes Scripts: 1_DDL_Tienda.sql y 2_DatosBD_Tienda.sql

3) Abrir el proyecto desde el IDE IntelliJ IDEA y realizar configuración del archivo appication-dev.properties:

    server.port=8090
    spring.datasource.url=jdbc:postgresql://localhost:5433/tienda-market
    spring.datasource.username=postgres
    spring.datasource.password=dlc12345

    Notas: 
      1- El puerto de configuración del servidor de aplicacióon es el 8090, pero se puede usar el 8080.
      2- El puerto de configuración para la base datos puede ser 5432 o 5433. 
      3- La base datos en este caso tiene el nombre de tienda-market. Si prefiere otro, se puede cambiar.
      4- El username de la base por defecto es postgres.
      5- Tener en cuenta que la contraseña de la base datos corresponda a la dada al momento de crear la base datos.

4) Quitar build.gradle: targetCompatibility = JavaVersion.VERSION_11 ( Se usa para la la compativilidad con Heroku, debido a que Heroku por defecto compila con la        versión Java 1.8.).

5) Ejecutar proyecto (Run -> TiendaMarketApplication). Si el servidor de aplicación subio sin inconvenientes, podemos probar desde el navegador o por Postman uno de      los servicios de la API:

   Por ejemplo: http://localhost:8090/tienda-market/api/product/all
_______________________

Cualquier comentario sobre el proyecto escribir al E-mail: lcdaneilf4@gmail.com

