# Creación y uso de SessionFactory y Session

En Hibernate, los objetos SessionFactory y Session son fundamentales para interactuar con la base de datos.

## SessionFactory

- Es un objeto pesado y único por aplicación (generalmente se implementa como *singleton*).  
- Contiene toda la configuración de Hibernate y los mapeos de clases entidad.  
- Es responsable de generar sesiones (Session) cuando la aplicación necesita interactuar con la base de datos.  
- Se crea una sola vez al inicio de la aplicación y se reutiliza durante todo el ciclo de vida de la aplicación.

Concepto clave: `SessionFactory` = fábrica de sesiones; configura y gestiona la conexión global a la base de datos.

## Session

- Representa una unidad de trabajo con la base de datos, similar a una conexión JDBC.  
- Cada sesión permite:
  - Guardar, actualizar, eliminar o consultar objetos.  
  - Gestionar transacciones.  
  - Hacer seguimiento de los cambios en objetos (caché de primer nivel).  
- Es ligera y efímera: se abre para un conjunto de operaciones y se cierra cuando se termina la transacción.

Concepto clave: `Session` = espacio de trabajo donde se realizan las operaciones sobre los objetos persistentes.

## Flujo

1. Crear un SessionFactory a partir de la configuración de Hibernate (XML o programática).  
2. Abrir una Session desde la SessionFactory.  
3. Iniciar una Transaction.  
4. Realizar operaciones CRUD sobre los objetos persistentes.  
5. Confirmar la transacción (commit) o revertirla (rollback) en caso de error.  
6. Cerrar la Session al finalizar.

### Objeto Pesado (heavyweight object)

Cuando hablamos de un objeto pesado no hablamos de su peso físico, sino de cuánto recurso consume y qué tan costoso es crearlo o mantenerlo.

Características
  Consume muchos recursos del sistema: memoria, conexiones a base de datos, hilos, etc.
  Es costoso de crear, inicializarlo tarda tiempo porque carga configuraciones o establece conexiones.
  Debe ser reutilizado en lugar de creado repetidamente, abrir y cerrar muchas veces sería ineficiente.

SessionFactory
  En Hibernate SessionFactory es considerado un objeto pesado
  Contiene toda la configuración de Hibernate y mapeos de entidades.
  Configura internamente conexiones y caches.
  Crear un SessionFactory desde cero implica procesar XML, registrar clases, inicializar caches…
  Se recomienda crear uno solo y reutilizarlo durante toda la aplicación.

Session
  En cambio, Session es un objeto ligero:
  Se crea rápido.
  Se abre y cierra con frecuencia.
  Maneja operaciones de manera temporal (unidad de trabajo).
