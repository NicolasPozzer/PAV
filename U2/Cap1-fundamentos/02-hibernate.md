# ¿Qué es Hibernate y para qué sirve?

1. Hibernate es un framework de mapeo objeto-relacional (ORM) para Java que permite:
    1. Mapear clases a tablas de una base de datos relacional.
    2. Automatizar la traducción de operaciones sobre objetos en sentencias SQL, es decir, pasar de una Clase a una Tabla SQL.
    3. Abstraer al programador de la mayoría del código SQL repetitivo.

De esta manera, Hibernate facilita la persistencia de datos (guardar, consultar, actualizar, eliminar) de manera natural trabajando con objetos Java.  

## ¿Por qué se utiliza?

En aplicaciones empresariales, una parte crítica es el almacenamiento de datos en bases relacionales. Para integrar el mundo orientado a objetos (Java) con el mundo relacional (SQL/BDs) surgieron frameworks ORM, siendo Hibernate uno de los más populares y robustos.

## Ventajas principales de Hibernate

1. Menos código SQL manual → las consultas básicas se generan automáticamente.  
2. Independencia del motor de base de datos → soporta diferentes SGBD
    1. MySQL
    2. PostgreSQL
    3. Oracle
    4. SQL Server
    5. ...
3. Portabilidad → se puede cambiar de base de datos con mínimos ajustes.
4. Mapeo flexible → soporta relaciones complejas (1:1, 1:N, N:M) y herencia.
5. Transacciones y caché → optimiza la interacción con la base de datos.
6. Integración con JPA → Java Persistence API es una especificación que define cómo deben funcionar los frameworks de persistencia en Java.
