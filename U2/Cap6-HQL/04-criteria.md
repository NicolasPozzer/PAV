# Criteria API

La API Criteria permite construir consultas de forma programática usando objetos Java en lugar de escribir texto HQL o SQL. Se suele usar cuando la consulta debe generarse dinámicamente, según condiciones variables.

## Características

1. Se basa en la composición de objetos (criterios, restricciones, órdenes, etc.).
2. Es segura frente a errores de sintaxis, ya que todo se escribe con clases y métodos.
3. Facilita consultas condicionales (por ejemplo, si el usuario selecciona ciertos filtros en una pantalla).
4. Ideal para consultas dinámicas o parametrizadas.
5. No requiere escribir manualmente cadenas de texto HQL.
6. Reduce el riesgo de errores por concatenar strings.
7. Es menos legible que HQL cuando la consulta es sencilla.
8. Puede volverse más verbosa (larga) para consultas complejas.
