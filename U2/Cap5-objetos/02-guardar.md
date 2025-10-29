# Guardar: save() y persist()

Ambos métodos permiten insertar un nuevo objeto en la base de datos.

1. Cuando un objeto se crea en memoria (por ejemplo, un nuevo Cliente), todavía no existe en la base de datos.
2. Al guardarlo con Hibernate, pasa a ser parte del contexto persistente y se genera una instrucción INSERT.

Diferencias conceptuales

1. save() es más propio de Hibernate: devuelve el identificador del objeto recién guardado.
2. persist() es parte del estándar JPA: no devuelve nada, pero sigue el mismo proceso.

En ambos casos, el objeto pasa del estado Transient a Persistent (veremos esos estados más abajo).
