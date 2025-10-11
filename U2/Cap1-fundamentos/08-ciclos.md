# Ciclo de vida de un objeto en Hibernate

En Hibernate, los objetos pasan por diferentes estados a lo largo de su vida cuando se relacionan con la base de datos.

Estos estados son: Transient, Persistent y Detached.

## Estado Transient (Transitorio)

El objeto ha sido creado en Java con new, pero no está asociado a una sesión de Hibernate ni a ninguna fila de la base de datos. Aún no tiene identificador asignado por Hibernate (PK). Si la aplicación termina en este punto, el objeto se pierde (no está guardado en la BD).

```java
Usuario u = new Usuario(); // Estado Transient
u.setNombre("Juan");
```

## Estado Persistent (Persistente)

El objeto está asociado a una sesión de Hibernate y corresponde a una fila de la base de datos. Hibernate realiza un seguimiento automático de los cambios en sus atributos (dirty checking). Cualquier modificación se sincroniza con la base al hacer commit o flush.

```java
Session session = factory.openSession();
Transaction tx = session.beginTransaction();

Usuario u = new Usuario();
u.setNombre("Ana");

// Al guardar, el objeto pasa a estado Persistent
session.save(u);

tx.commit();
session.close();
```

## Estado Detached (Separado)

El objeto estuvo en estado Persistent, pero la sesión de Hibernate se cerró. Ya no está asociado a ninguna sesión activa. Puede seguir existiendo en la memoria de Java, pero Hibernate no lo sincroniza más con la BD. Para volver a hacerlo persistente, debe re-adjuntarse con update() o merge().

```java
Session session = factory.openSession();
Usuario u = session.get(Usuario.class, 1); // Persistent
session.close(); // La sesión se cierra

// Ahora 'u' está en estado Detached
u.setNombre("Carlos"); 
// Cambios no impactan en BD hasta re-asociarlo
```
