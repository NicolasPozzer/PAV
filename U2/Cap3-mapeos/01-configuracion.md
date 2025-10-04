# Archivo de configuración hibernate.cfg.xml

Hibernate necesita un archivo de configuración para conocer cómo conectarse a la base de datos y qué parámetros usar. Este archivo suele llamarse hibernate.cfg.xml y se coloca en el classpath del proyecto (por lo general dentro de src/main/resources).

## Contenido principal

1. Datos de conexión a la base de datos
    Driver JDBC a utilizar.
    URL de la base de datos.
    Usuario y contraseña.

2. Propiedades de Hibernate
    Dialecto de SQL según el motor de base de datos (MySQL, PostgreSQL, Oracle, etc.).  
    Estrategia de creación de tablas (hbm2ddl.auto).  
    Mostrar o no las sentencias SQL en consola (show_sql).  

3. Mapeo de clases
    Hibernate debe saber qué clases Java están mapeadas como entidades.  
    Se especifican en el archivo o se registran de manera programática.  

## Parámetros típicos

1. hibernate.connection.driver_class
    → driver JDBC (ej: com.mysql.cj.jdbc.Driver).  

2. hibernate.connection.url
    → URL de la base (ej: jdbc:mysql://localhost:3306/miBD).

3. hibernate.connection.username / hibernate.connection.password
    → credenciales de acceso.  

4. hibernate.dialect
    → traducción SQL según el motor (ej: org.hibernate.dialect.MySQL8Dialect).  

5. hibernate.hbm2ddl.auto
    → cómo manejar las tablas:
        create → crea de cero cada vez.  
        update → actualiza si es necesario.  
        validate → solo valida el esquema.  
        none → no hace nada automático.  

6. hibernate.show_sql
    → muestra en consola las sentencias SQL ejecutadas.  

## Función en el flujo de Hibernate

El archivo hibernate.cfg.xml es leído al inicio para:

1. Construir el objeto SessionFactory con toda la configuración.  
2. Establecer cómo Hibernate se conecta y trabaja con la base.  
3. Registrar las clases anotadas que representan entidades.  

## Concepto Final

Es la base de la configuración: sin este archivo (o su equivalente programático), Hibernate no puede funcionar.  
