# Temas avanzados

Ademas de mapear objetos y hacer consultas, Hibernate ofrece mecanismos de optimización, integración y rendimiento que son esenciales en aplicaciones grandes.

## Caché de primer nivel (First-Level Cache)

Está siempre activa y es interna de Hibernate. Está asociada a la Session (objeto que representa una unidad de trabajo con la base de datos). Al recuperar una entidad, Hibernate la guarda en memoria dentro de esa sesión. Si luego se vuelve a solicitar el mismo objeto, no se ejecuta otra consulta SQL, sino que se obtiene directamente del caché.

1. Ejemplo: Si dentro de una misma sesión se pide el mismo cliente varias veces, Hibernate lo recupera de memoria y no de la base de datos.

2. Características:
    Automática y obligatoria.
    Dura mientras la sesión esté abierta.
    Mejora el rendimiento y evita consultas repetidas innecesarias.

## Caché de segundo nivel (Second-Level Cache)

Es opcional y se configura explícitamente. Permite guardar entidades más allá de una sesión, compartiendo datos entre distintas sesiones o incluso distintos usuarios. Utiliza herramientas externas como EhCache, Infinispan, o Caffeine.

1. Ejemplo: Si varios usuarios consultan los mismos productos o categorías, Hibernate puede mantener esos datos en memoria (caché compartido), evitando que se consulten en la base cada vez.

2. Características:
    Mejora notablemente el rendimiento en sistemas con muchas lecturas.
    Reduce la carga sobre la base de datos.
    Aumenta la complejidad de configuración.
    Puede generar inconsistencias si los datos cambian con frecuencia y el caché no se sincroniza correctamente.
