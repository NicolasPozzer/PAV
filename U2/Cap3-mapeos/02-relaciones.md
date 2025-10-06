# Mapeo Relaciones

En una base de datos relacional, las tablas se relacionan entre sí mediante claves foráneas. Hibernate traduce esas relaciones al mundo de los objetos a través de asociaciones entre clases. Estas relaciones pueden ser uno a uno, uno a muchos, muchos a uno o muchos a muchos.

## 1. One-to-One (@OneToOne)

- Una instancia de una entidad está asociada con una única instancia de otra entidad.  

- Ejemplo
  - Una Persona tiene un Pasaporte.  
  - En base de datos, esto se traduce en una relación de clave foránea única.

Persona (1) ─── (1) Pasaporte

- Se usa @OneToOne para indicar la relación.
- Puede definirse en uno o ambos lados, dependiendo de quién mantenga la clave foránea.

## 2. One-to-Many (@OneToMany, @ManyToOne)

- Una instancia de una entidad puede estar asociada con muchas instancias de otra.  
- En el sentido inverso, cada una de esas instancias pertenece a una sola entidad principal.

- Ejemplo
  - Un Cliente tiene muchos Pedidos.  
  - Cada Pedido pertenece a un solo Cliente.

Cliente (1) ────< Pedido (N)

- @OneToMany: se coloca en la entidad “padre” (por ejemplo, Cliente).  
- @ManyToOne: se coloca en la entidad “hija” (por ejemplo, Pedido).

Esta es la relación más común en sistemas reales.

## 🔄 3. Many-to-Many (@ManyToMany)

- Una instancia de una entidad puede estar asociada con muchas instancias de otra, y viceversa.
- En la base de datos, se implementa mediante una tabla intermedia que contiene las claves de ambas entidades.

- Ejemplo
  - Un Estudiante puede estar inscrito en muchos Cursos,  
  - y un Curso puede tener muchos Estudiantes.

Estudiante (N) ───< Inscripción >─── (N) Curso

- @ManyToMany define la asociación.  
- Hibernate crea automáticamente (o usa) una tabla de unión.

## Conceptos adicionales

### Propiedad de la relación

- En cada asociación, uno de los lados “posee” la relación,  
  es decir, mantiene la clave foránea o la tabla intermedia.  
- Se controla con el atributo mappedBy.

### Cascadas

- Hibernate puede propagar operaciones (guardar, eliminar, actualizar)  
  de una entidad a las relacionadas usando la propiedad cascade.

### Carga diferida

- Por defecto, las relaciones suelen ser lazy (se cargan sólo cuando se acceden).  
- Esto optimiza el rendimiento.

## Resumen conceptual

| Tipo de relación | Anotación principal | Descripción | Ejemplo |
|------------------|--------------------|--------------|----------|
| One-to-One | @OneToOne | Un objeto se asocia con uno solo | Persona ↔ Pasaporte |
| One-to-Many / Many-to-One | @OneToMany, @ManyToOne | Un objeto tiene muchos, pero cada uno pertenece a uno | Cliente → Pedidos |
| Many-to-Many | @ManyToMany | Muchos objetos asociados con muchos | Estudiante ↔ Curso |

En síntesis:
> Hibernate permite expresar relaciones entre objetos igual que las relaciones entre tablas,  
> pero de forma orientada a objetos, sin necesidad de manejar claves foráneas manualmente.
