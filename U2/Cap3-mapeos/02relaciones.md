# Mapeo de Relaciones

El modelo relacional establece que las relaciones entre tablas se implementan mediante valores de datos compartidos, que IDEALMENTE deben formalizarse como claves foráneas para garantizar la integridad referencial. Hibernate traduce esas relaciones al mundo de los objetos a través de asociaciones entre clases. Estas relaciones pueden ser uno a uno, uno a muchos, muchos a uno o muchos a muchos.

## One-to-One (@OneToOne)

Una instancia de una entidad está asociada con una única instancia de otra entidad.

### Ejemplo: Persona - Pasaporte

+ Una Persona tiene_un Pasaporte, como mínimo y como máximo. (1:1)
+ Una Pasaporte pertenece_a una Persona, como mínimo y como máximo. (1:1)

Cardinalidad: Persona (1:1) ─── (1:1) Pasaporte
Correspondencia:(1:1)

Reglas de propagación: Clave Foránea
La FK se ubica en la entidad más débil o la que depende de la otra.
¿Pasaporte depende de la Persona? → FK en Credencial
¿La Persona depende de la Pasaporte? → No

### Hibernate

```java
@Entity
public class Persona {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String dni;
    @OneToOne(mappedBy = "persona", cascade = CascadeType.ALL)
    private Pasaporte pasaporte;  // ← Lado no propietario
    // constructores, getters y setters...
}

@Entity
public class Pasaporte {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String numero;
    private String paisEmisor;
    @OneToOne
    @JoinColumn(name = "persona_id")  // ← Lado propietario (tiene la FK)
    private Persona persona;
    // constructores, getters y setters
}
```

### Base de Datos

```sql
CREATE TABLE persona (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    nombre VARCHAR(100),
    dni VARCHAR(20)
);

CREATE TABLE pasaporte (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    numero VARCHAR(50) UNIQUE,
    pais_emisor VARCHAR(50),
    persona_id BIGINT UNIQUE,  -- ← CLAVE FORÁNEA
    FOREIGN KEY (persona_id) REFERENCES persona(id)
);

```

### Uso

```java
// Crear relación
Persona persona = new Persona("Juan Pérez", "12345678");
Pasaporte pasaporte = new Pasaporte("AB123456", "Argentina");

persona.setPasaporte(pasaporte);
pasaporte.setPersona(persona);

// Al guardar la Persona, se guarda el Pasaporte automáticamente (cascade)
session.save(persona);
```

## One-to-Many (@OneToMany, @ManyToOne)

Una instancia de una entidad puede estar asociada con muchas instancias de otra. En el sentido inverso, cada una de esas instancias pertenece a una sola entidad principal.

### Ejemplo: Cliente - Pedido

+ Un Cliente puede_tener desde [0,1] a [muchos] Pedidos. (1:N)
+ Un Pedido pertenece_a un solo Cliente. (1:1)

Cardinalidad: Cliente (1:1) ─── (1:N) Pedidos
Correspondencia:(1:N)

+ @OneToMany: se coloca en la entidad “padre” (Cliente).
+ @ManyToOne: se coloca en la entidad “hija” (Pedido).

Esta es la relación más común en sistemas reales.

## Many-to-Many (@ManyToMany)

Una instancia de una entidad puede estar asociada con muchas instancias de otra, y viceversa. En la base de datos, se implementa mediante una tabla intermedia que contiene las claves de ambas entidades.

### Ejemplo: Estudiante - Curso

+ Un Estudiante puede_inscribirse desde [0,1] a [muchos] Cursos. (1:N)
+ Un Curso puede_tener desde [0,1] a [muchos] Estudiantes. (1:N)

Cardinalidad: Cliente (1:N) ─── (1:N) Pedidos
Correspondencia:(N:M)

+ @ManyToMany define la asociación.
+ Hibernate crea automáticamente (o usa) una tabla de unión.

## Conceptos adicionales

### Propiedad de la relación

+ En cada asociación, uno de los lados “posee” la relación, es decir, mantiene la clave foránea o la tabla intermedia.  
+ Se controla con el atributo mappedBy.

### Cascadas

+ Hibernate puede propagar operaciones (guardar, eliminar, actualizar) de una entidad a las relacionadas usando la propiedad cascade.

### Carga diferida

+ Por defecto, las relaciones suelen ser lazy (se cargan sólo cuando se acceden). Esto optimiza el rendimiento.
