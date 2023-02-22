Cliente Api

-- Java
- com.agora.clienteservice

-Configurations:
    SwaggerConfig : Configuracion recurso Swagger.
    WebMvcCustomConfiguration: exposicion y manejo del recurso web para el swagger.

-Controllers:
    ClienteController: expone las funciones de la api hacia afuera.
                       Seteo de las url/path de cada metodo.
-Converter:
    ClienteConverter: Conversion de Entidad a DTO y viceversa.

-CustomExceptions
    RequestExceptions: Excepcion custom para request.

-DTO
     ClienteDTO: Unifica los datos que recibe y expone la api para la entidad Cliente.
     Contiene validaciones y formatos de los campos.

-ExceptionHandlers
    ValidationExceptionConfig: Configuracion y manejo de excepciones referidas a las validaciones de los campos (Contiene los mensajes de respuesta).

-Models
    Entidades: Cliente (Define la tabla Cliente en la DB).
    KpiCliente: Define el objeto KpiCliente que expone el negocio.

-Repositories
    ClienteRepository: Interface que expone los metodos JPA para interactuar con la base de datos.

-Services
    ClienteService: Desarrolla la logica del negocio que exponen los distintos metodos.

-Utils
    CalculosAuxiliares: Expone metodos matematicos que podrian requerirse en distintas soluciones (Ej: Promedios,DesviacionEstandar).


--Resources
-Api
    test-api-swagger.yaml - Contiene el seteo y configuracion que expone la interface grafica Swagger UI.
-Application.Properties
    Propiedades de la conexion a la Base de Datos(User/Password, url, driver).

Test
-Java: Test unitarios

-Postman: Collection con pruebas automatizadas para postman. (Importar collection file en postman)


Swagger:
http://testapi-jpa.rj.r.appspot.com/swagger-ui.html