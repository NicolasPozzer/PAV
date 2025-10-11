# Arquitectura de Hibernate

Hibernate está compuesto por varios componentes que permiten la interacción entre las clases Java y la base de datos relacional. Su arquitectura se organiza en capas, donde Hibernate se ubica entre la aplicación y la base de datos.

## Componentes principales

### SessionFactory

1. Objeto pesado y único por aplicación. Generalmente implementado como *singleton*
2. Se crea a partir de la configuración (`hibernate.cfg.xml`)
3. Contiene la información de mapeo (clases ↔ tablas)
4. Genera instancias de `Session`

```java
SessionFactory factory = new Configuration()
.configure("hibernate.cfg.xml")
.buildSessionFactory();
```

Nota: El patrón Singleton es un patrón de diseño en programación que garantiza que una clase tenga una única instancia en todo el sistema, y que además proporcione un punto de acceso global a esa instancia.

### Session

1. Es una unidad de trabajo que representa una conexión con la base de datos.
2. Es ligera y debe abrirse y cerrarse según la operación.
3. Permite realizar CRUD, crear consultas y manejar transacciones.
4. Implementa el caché de primer nivel (almacena objetos en memoria durante la sesión).

```java
Session session = factory.openSession();
```

### Transaction

1. Maneja la lógica de ACID (atomicidad, consistencia, aislamiento, durabilidad).
2. Garantiza que un conjunto de operaciones se ejecute de forma segura.
3. Se debe comenzar y confirmar (commit) o revertir (rollback).

```java
Transaction tx = session.beginTransaction();
// operaciones CRUD
tx.commit();
```

### Query

Permite ejecutar consultas usando:

1. HQL (Hibernate Query Language) → orientado a objetos.
2. SQL nativo → si se necesita control total.
3. Criteria API → consultas programáticas.

```java
Query query = session.createQuery("FROM Usuario WHERE nombre = :nombre");
query.setParameter("nombre", "Ana");
List<Usuario> lista = query.list();
```

## Interacción con BD

1. La aplicación crea un objeto SessionFactory. La aplicación arranca y crea un SessionFactory.
2. A través de este, se abre una Session para conectarse a la BD. Se abre una Session para trabajar con la base.
3. Dentro de la sesión se inicia una Transaction. Se inicia una Transaction.
4. El desarrollador interactúa con objetos Java (persistencia transparente). Se realizan operaciones sobre objetos (guardar, consultar, actualizar, borrar).
5. Hibernate traduce las operaciones en SQL y las ejecuta sobre la BD. Hibernate traduce esas operaciones a SQL y las ejecuta en la base.
6. Al finalizar, se hace commit/rollback de la transacción y se cierra la sesión. Se confirma (commit) o se revierte (rollback) la transacción. Se cierra la sesión.

`Aplicación → SessionFactory → Session → Transaction → SQL → Base de Datos`
