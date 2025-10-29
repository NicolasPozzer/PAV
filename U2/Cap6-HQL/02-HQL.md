# HQL (Hibernate Query Language)

HQL es un lenguaje de consulta propio de Hibernate, muy similar a SQL, pero que trabaja sobre entidades, atributos y relaciones, no sobre tablas y columnas. Por ejemplo, en lugar de consultar la tabla clientes, se consulta la entidad Cliente.

## Características

1. Su sintaxis se parece a SQL, pero es independiente de la base de datos.
2. Hibernate se encarga de traducir las consultas HQL a SQL real.
3. Permite usar cláusulas familiares como:
    1. FROM → para seleccionar entidades.
    2. WHERE → para filtrar resultados.
    3. ORDER BY → para ordenar.
    4. JOIN → para unir entidades relacionadas.
4. Más portable entre distintos motores de base de datos.
5. Permite aprovechar las relaciones mapeadas entre entidades.
6. Es más expresivo y limpio que el SQL tradicional.
7. Menor control sobre operaciones muy específicas o consultas complejas a nivel SQL.
8. No siempre permite aprovechar funciones nativas del motor de base de datos.
