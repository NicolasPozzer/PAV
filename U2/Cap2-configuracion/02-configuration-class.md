# Configuración programática con Configuration

Además del archivo hibernate.cfg.xml, Hibernate permite configurar todo directamente desde código Java, usando la clase Configuration.  

Esta opción es útil cuando se quiere:
   Evitar archivos XML adicionales.  
   Definir la configuración de forma dinámica según el entorno.  
   Registrar clases entidad y propiedades directamente en el código.

## Concepto

La clase Configuration permite definir propiedades de conexión, dialecto, comportamiento de Hibernate y clases entidad sin usar XML. Al final, la Configuration se usa para construir un SessionFactory, que es la base para abrir sesiones y trabajar con la base de datos.

## Elementos principales configurables programáticamente

1. Propiedades de conexión
   Driver, URL, usuario, contraseña.
   Dialecto de la base de datos.
   Opciones de show_sql, format_sql, etc.

2. Mapeo de clases
   Registrar clases entidad directamente con addAnnotatedClass(ClassName.class).

3. Construcción de SessionFactory
   Una vez configuradas todas las propiedades y clases, se construye la SessionFactory con buildSessionFactory(). A partir de allí se abren Session para interactuar con la BD.

## Ventajas de la configuración programática

Flexibilidad: se puede cambiar la configuración según el entorno (desarrollo, pruebas, producción).
Evita archivos XML: todo queda centralizado en código.
Integración más sencilla con frameworks que requieren configuración por código (Spring, por ejemplo).

## Idea conceptual

1. Crear un objeto Configuration.
2. Definir propiedades de conexión y opciones de Hibernate.
3. Registrar clases entidad.
4. Construir SessionFactory → listo para abrir sesiones y manejar transacciones.

En resumen: la configuración programática es otra forma de decirle a Hibernate cómo conectarse a la base y qué clases manejar, pero todo directamente desde Java sin XML.
