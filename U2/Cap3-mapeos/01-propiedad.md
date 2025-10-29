# Mapeo Propiedad

El mapeo es el proceso por el cual Hibernate asocia a los atributos de una clase Java con las columnas de una tabla en la base de datos. Este es el nivel más básico del mapeo ORM (Object-Relational Mapping).

## Atributos simples (@Column, tipos básicos)

Cada atributo de la clase que queramos almacenar en la base de datos debe estar mapeado a una columna mediante la anotación @Column.

1. @Column: permite definir el nombre de la columna y sus características.
    + name: nombre de la columna en la base de datos.
    + nullable: si la columna puede o no ser nula.
    + length: longitud máxima (para cadenas de texto).
    + unique: si la columna debe tener valores únicos.

Hibernate convierte automáticamente los tipos de datos Java en los tipos SQL equivalentes (por ejemplo, String → VARCHAR, int → INTEGER).

Ejemplo conceptual:

+ Atributo Java → Columna SQL
+ String nombre → nombre VARCHAR
+ int edad → edad INTEGER
+ Date fechaAlta → fecha_alta DATE

## Claves primarias (@Id, @GeneratedValue)

Cada entidad necesita una clave primaria para identificar de forma única a cada registro.

1. @Id  
    Indica cuál es el atributo que funciona como clave primaria.

2. @GeneratedValue  
    Define cómo se genera el valor de esa clave.  
    Los modos más comunes son:
    + GenerationType.IDENTITY: el valor se genera automáticamente por la base (auto_increment).
    + GenerationType.SEQUENCE: usa una secuencia definida en la base de datos.
    + GenerationType.TABLE: usa una tabla auxiliar para generar los IDs.
    + GenerationType.AUTO: Hibernate elige la estrategia más adecuada según el motor de base de datos.

## Conceptualmente

+ @Column define cómo se representa cada atributo de la clase en la tabla.  
+ @Id define cuál atributo identifica de forma única cada objeto.  
+ @GeneratedValue define cómo se genera ese identificador.  
+ En conjunto, permiten a Hibernate traducir los objetos Java en filas y columnas.

## Resumen conceptual

| Anotación | Propósito | Ejemplo conceptual |
|------------|------------|--------------------|
| @Column | Mapea un atributo a una columna | String nombre → columna NOMBRE |
| @Id | Define la clave primaria | int id |
| @GeneratedValue | Indica cómo se genera el id | AUTO_INCREMENT, SEQUENCE, etc. |

## En resumen

El mapeo de propiedad establece la relación básica entre una clase Java y su tabla correspondiente, permitiendo que Hibernate traduzca de forma automática los objetos a registros de base de datos.
