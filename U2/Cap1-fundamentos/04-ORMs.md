# ORMs | Object Relational Mapping

## ¿Qué es un ORM?

Un ORM (Object-Relational Mapping) es una técnica de programación que funciona como un puente de traducción entre el mundo orientado a objetos de los lenguajes de programación y el mundo relacional de las bases de datos.

En esencia, es un intermediario que permite a los desarrolladores trabajar con bases de datos utilizando los paradigmas y estructuras de su lenguaje de programación preferido, sin necesidad de escribir consultas SQL de manera directa.

## La analogía del traductor

Pensemos en un ORM como un intérprete humano en una conversación entre dos personas que hablan idiomas diferentes. Tú le das instrucciones en tu idioma nativo (objetos y métodos de programación), y el ORM se encarga de traducirlas al lenguaje de la base de datos (SQL), luego toma la respuesta de la base de datos y te la devuelve en tu idioma original.

## Desfase de impedancia y ¿por qué Existen los ORMs?

Impedancia en ORM: La Impedancia en ORM es la pérdida inevitable de significado que ocurre al traducir entre dos lenguajes conceptualmente distintos: el mundo de los objetos (rico en comportamiento y relaciones) y el mundo de las bases de datos (estructurado en tablas y registros).

"Impedancia = La fricción conceptual entre paradigmas"

Es como traducir poesía: las palabras pueden pasar de un idioma a otro, pero la esencia, el ritmo y las connotaciones culturales siempre sufren alguna pérdida.

Analogía simple para recordar:
"Es el 'costo de traducción' entre el lenguaje de los objetos (Java) y el lenguaje de las bases de datos (SQL). Cada vez que cruzamos la frontera entre estos dos mundos, algo del significado original se disipa o transforma."

En esencia:
De objetos → BD: Pierdes comportamiento, herencia, polimorfismo
De BD → objetos: Pierdes la estructura relacional pura, integridad referencial inmediata

El ORM es el puente que minimiza esta pérdida, pero nunca la elimina completamente.

Es el conflicto entre dos formas distintas de representar y manipular datos. El problema del Desfase de Impedancia describe el conflicto fundamental entre la forma en que organizamos datos en la programación orientada a objetos (clases, herencia, objetos) y cómo se almacenan en bases de datos relacionales (tablas, filas, columnas).

1. Este tipo de traducción entre estructuras no es trivial. El desfase aparece porque:
    1. Java usa referencias y objetos y SQL usa tablas y relaciones explícitas.
    2. Java permite herencia y SQL no la soporta directamente.
    3. Java tiene tipos complejos, SQL tiene tipos primitivos.

2. Un ORM como Hibernate actúa como puente traductor:
    1. Mapea las clases a tablas.
    2. Convierte atributos en columnas.
    3. Traduce relaciones en claves foráneas.
    4. Genera automáticamente las consultas SQL necesarias.
    5. Permite trabajar con objetos sin preocuparse por el SQL subyacente.

3. Resultado. Con un ORM se puede:

    1. usar session.save(marca) en lugar de escribir INSERT INTO marca (...)
    2. navegar relaciones como marca.getModelos() sin escribir JOIN.
    3. cambiar la base de datos sin reescribir todo el acceso a datos.

Los ORMs nacieron para resolver este desfase, permitiendo que ambos mundos coexistan de manera armoniosa.

## Consideraciones

1. Curva de Aprendizaje
    Cada ORM tiene su propia API y patrones de uso, lo que requiere tiempo de aprendizaje. Los desarrolladores deben familiarizarse no solo con el ORM mismo, sino también con sus convenciones y mejores prácticas.

2. Rendimiento en Casos Específicos
    Para consultas extremadamente complejas u optimizadas, un ORM puede generar consultas SQL menos eficientes que las escritas manualmente por un experto en bases de datos.

3. Complejidad en Escenarios Avanzados
    Cuando las necesidades van más allá de las operaciones CRUD típicas, la abstracción del ORM puede volverse una limitación en lugar de una ventaja, requiriendo workarounds o escapes hacia SQL nativo.

4. Dependencia de una Herramienta Externa
    Introducir un ORM significa agregar una dependencia significativa al proyecto, con sus propios ciclos de actualización, problemas de compatibilidad y curva de mantenimiento.
