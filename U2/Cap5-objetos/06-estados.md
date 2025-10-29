# Estados de los objetos

El comportamiento de los métodos CRUD depende del estado en que se encuentra cada objeto dentro del ciclo de vida de Hibernate.

1. Transient (transitorio)
    El objeto existe solo en memoria (aún no se guardó en la base de datos).
    Hibernate no lo está controlando.
    Si el programa finaliza o se cierra la sesión, el objeto se pierde.
    Ejemplo: Se crea un nuevo “Cliente” en Java, pero aun no se guarda.

2. Persistent (persistente)
    El objeto está siendo gestionado por Hibernate.
    Cualquier cambio que hagas en él se sincroniza automáticamente con la base de datos al hacer commit o flush.
    Hibernate mantiene una copia del objeto en su contexto de persistencia (la sesión).
    Ejemplo: Se guarda el cliente con save() o se consulta con get(). Ahora, Hibernate sabe que existe y puede actualizarlo o eliminarlo.

3. Detached (desasociado)
    El objeto fue persistente, pero la sesión se cerró.
    Aún existe en memoria, pero Hibernate ya no lo está controlando.
    Si se lo modifica  en este estado, los cambios no se guardan automáticamente. Se debe usar update() o merge() para volver a sincronizarlo.
    Ejemplo: Se carga un cliente desde la base, se cierra la sesión y luego se cambia su nombre. Hibernate no lo notará hasta que se realice un merge().
