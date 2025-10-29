# Resumen

1. HQL → Lenguaje similar a SQL pero trabaja con entidades. Ideal para consultas predecibles o reportes.
2. Named Queries → Consultas HQL definidas una sola vez y reutilizables.
3. Criteria API → Consultas dinámicas construidas con objetos Java. Ideal cuando los filtros cambian según la lógica del programa.
4. Native SQL → Consultas SQL reales, útiles solo cuando necesitas algo que HQL o Criteria no pueden expresar fácilmente.

## Conclusión

Hibernate ofrece distintas formas de consultar los datos, y cada una se adapta a distintas necesidades:

1. HQL, cuando se necesite escribir consultas parecidas a SQL, pero sobre entidades.
2. Criteria, cuando se necesite construir consultas de manera flexible y programática.
3. Named Queries, para reutilizar consultas fijas.
4. Native SQL, solo como último recurso, cuando se necesite acceso directo al motor de base de datos.
