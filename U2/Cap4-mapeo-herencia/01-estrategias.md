# Mapeo de herencia en Hibernate

En la programación orientada a objetos, una clase puede heredar atributos y comportamientos de otra (por ejemplo, Empleado puede ser la clase base, y EmpleadoTiempoCompleto y EmpleadoMedioTiempo pueden ser subclases).

El problema es que las bases de datos relacionales no manejan herencia directamente: trabajan con tablas y relaciones.

Por eso, Hibernate ofrece tres estrategias principales para representar la herencia de clases en la base de datos.

## 1. Estrategia: SINGLE_TABLE

Todas las clases de la jerarquía (la clase base y sus subclases) se almacenan en una sola tabla.
Esa tabla contiene todas las columnas posibles, tanto de la superclase como de las subclases, y una columna adicional (llamada discriminadora) indica el tipo de cada fila.

+ Es la más rápida en consultas, ya que toda la información está en una única tabla.
+ Es simple de implementar y fácil de mantener.
+ Hibernate no necesita hacer joins entre tablas.

+ Muchos campos pueden quedar vacíos (NULL), especialmente si las subclases tienen atributos distintos.
+ La tabla puede volverse muy grande y poco eficiente si la jerarquía es compleja.
+ No está muy normalizada (hay redundancia estructural).

+ Cuándo usarla
  + Cuando la jerarquía es pequeña.
  + Cuando el rendimiento de lectura es más importante que la pureza del modelo.
  + En aplicaciones donde no hay gran variación entre las subclases.

## Estrategia: JOINED

Cada clase tiene su propia tabla, pero las subclases se unen (JOIN) con la tabla de la clase base para obtener todos sus datos. La tabla base contiene los atributos comunes, y las subclases solo guardan los atributos específicos.

+ El modelo está bien normalizado: no hay datos redundantes ni columnas vacías.
+ Es flexible y más fiel al modelo orientado a objetos.
+ Permite mantener una estructura clara y extensible.

+ Requiere joins en casi todas las consultas, lo que puede afectar el rendimiento.
+ Las operaciones de inserción y actualización son más lentas porque involucran varias tablas.
+ La configuración y las consultas pueden ser un poco más complejas.

+ Cuándo usarla
  + Cuando la jerarquía es grande o compleja.
  + Cuando se busca normalización y consistencia de datos.
  + En sistemas donde las relaciones entre clases son importantes y se valora la integridad estructural.

## Estrategia: TABLE_PER_CLASS

Cada clase concreta (es decir, cada subclase) tiene su propia tabla completa, que incluye tanto los atributos heredados como los suyos propios.
La superclase no tiene una tabla en común.

+ Las consultas a subclases específicas son muy rápidas (no hay joins).
+ Las tablas son independientes y simples de entender.
+ No hay columnas vacías ni necesidad de discriminadores.

+ No hay una tabla común, por lo tanto, las consultas que involucren la superclase deben usar unión de tablas (UNION), lo que puede ser costoso.
+ Puede haber duplicación de columnas en distintas tablas (los atributos heredados se repiten).
+ Menor consistencia entre tablas si cambian los atributos de la clase base.

+ Cuándo usarla
  + Cuando las subclases son muy diferentes entre sí y casi no comparten campos.
  + Cuando las consultas polimórficas (sobre la superclase) no son frecuentes.
  + En sistemas donde la independencia entre tipos de entidades es prioritaria.

## Comparación general

SINGLE_TABLE: simple y rápida, pero poco flexible.
JOINED: equilibrada y bien estructurada, ideal para la mayoría de los casos.
TABLE_PER_CLASS: útil para jerarquías donde cada subclase es casi independiente.

En la práctica, la estrategia JOINED suele ser la más recomendada porque ofrece un buen balance entre normalización y rendimiento, sin generar tantos datos nulos ni redundantes.
