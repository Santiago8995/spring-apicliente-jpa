Cliente Api

-- Java
- com.agora.clienteservice

-Configurations:
    Configuracion recurso Swagger: SwaggerConfig.
    WebMvcCustomConfiguration: exposicion del recurso Swagger configurado.

-Controllers:
    ClienteController: expone las funciones de la api hacia afuera.
                       Seteo de las url/path de cada metodo.

-DAO
     Metodos Data Acces Object entre la api y el repositorio de la DB.
     ClienteDAO: Interface que expone los metodos del DAO.
     ClienteDaoImpl: Contiene la implementacion de los metodos DAO.

-DTO
     ClienteDTO: Unifica los datos que recibe y expone la api para la entidad Cliente.
     Contiene validaciones y formatos de los campos.

-ExceptionHandlers
    ValidationExceptionConfig: Configuracion y manejo de excepciones referidas a las validaciones de los campos (Contiene armado de los mensajes de respuesta).

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


