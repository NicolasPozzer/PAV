# Named Queries (@NamedQuery)

Son consultas HQL predefinidas y asociadas a una entidad. Se declaran una vez (por ejemplo, encima de una clase) y luego se pueden ejecutar en cualquier parte del código sin volver a escribirlas.

## Características

1. Centralizan y reutilizan consultas comunes.
2. Mejoran la organización y mantenimiento del código.
3. Evitan errores de sintaxis repetidos en distintas partes de la aplicación.

## Casos de uso

1. Consultas frecuentes y estables, como:
    1. Buscar todos los registros de una entidad.
    2. Filtrar por campos comunes.
    3. Consultas de reportes estándar.
