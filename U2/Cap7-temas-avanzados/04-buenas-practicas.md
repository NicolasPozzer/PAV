# Buenas prácticas

## El problema de las N+1 queries

Ocurre cuando se ejecuta una consulta principal (1 query) y, por cada resultado obtenido, Hibernate realiza una consulta adicional (N consultas). Por eso se llama N+1: una principal + una por cada fila recuperada.

Ejemplo: Se desea hacer una lista de clientes, y que cada cliente tiene una lista de pedidos.

1. Hibernate podría comportarse así:
    1. Primera consulta (1). Hibernate ejecuta una consulta principal para traer la lista de clientes: SELECT * FROM cliente; → Esto obtiene los 10 clientes
    2. Luego, una consulta por cada cliente (N consultas). Por cada cliente de esa lista, Hibernate hace una consulta adicional para cargar sus pedidos (si la relación pedidos está configurada como Lazy y se accede después): SELECT * FROM pedido WHERE cliente_id = ?; → Si hay 10 clientes, eso implica 10 consultas adicionales (una por cliente). Por eso se lo llama el problema “N + 1 queries”: 1 para obtener la lista principal (clientes). N adicionales para obtener los pedidos de cada uno. Total: 11 consultas, no 10.

2. Cómo evitarlo: Usar JOIN FETCH en las consultas HQL o Criteria para traer las relaciones necesarias en una sola consulta. Configurar correctamente fetch = EAGER solo cuando sea necesario. Revisar las relaciones bidireccionales para evitar cargas redundantes.

## Optimización de consultas y relaciones

1. Objetivo
    Reducir la cantidad de consultas, minimizar el tráfico hacia la base y aprovechar el caché.

2. Buenas prácticas comunes
    1. Utilizar paginación (setMaxResults, setFirstResult) en consultas grandes.
    2. Definir correctamente las estrategias de carga (Lazy vs Eager).
    3. Hacer uso del segundo nivel de caché para datos estáticos.
    4. Aplicar batch fetching (cargar colecciones o asociaciones en bloques).
    5. Evitar traer datos que no se necesitan (solo seleccionar los campos requeridos).

## Uso de transacciones distribuidas

Una transacción distribuida es aquella que abarca más de una fuente de datos o más de un sistema (por ejemplo, dos bases de datos, o una base de datos y un sistema de mensajería). Hibernate puede integrarse con manejadores de transacciones distribuidas (JTA) para garantizar que todas las operaciones se realicen de forma atómica:

1. Si una falla, todas se revierten.
2. Si todas se completan, se confirman juntas.

Ejemplo: Un sistema bancario que debe: Debitar dinero de una cuenta en un servidor. Acreditarlo en otra cuenta en un servidor distinto. Si uno de los pasos falla, la transacción completa debe deshacerse.

→ Garantiza consistencia de datos en entornos complejos y distribuidos.
→ Aumenta la complejidad técnica y el costo de mantenimiento.
