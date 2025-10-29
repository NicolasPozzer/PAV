# Clases entidad con anotaciones (@Entity, @Id, @Column)

En Hibernate, cada clase Java que queremos persistir en la base de datos se define como entidad. Para indicar esto, usamos anotaciones, que permiten mapear los atributos de la clase a las columnas de la tabla correspondiente.

## 1. @Entity

Marca la clase como una entidad gestionada por Hibernate. Hibernate la identifica como una tabla de la base de datos (con nombre igual al de la clase, a menos que se especifique otro). Obligatorio para todas las clases que se van a persistir.

## 2. @Id

Define cuál atributo será la clave primaria de la tabla. Hibernate usa este campo para identificar de manera única cada fila y controlar el ciclo de vida de los objetos. Suele combinarse con @GeneratedValue para generar automáticamente valores de clave primaria.

## 3. @Column

Permite mapear un atributo de la clase a una columna específica de la tabla.  
Se pueden definir propiedades como:

1. Nombre de la columna (name)  
2. Longitud (length)  
3. Si puede ser nulo o no (nullable)  
4. Si es único (unique)  

## Conceptualizacion

1. Cada clase entidad representa una tabla.
2. Cada atributo representa una columna.  
3. Las anotaciones indican a Hibernate cómo hacer este mapeo objetoelacional de manera transparente.  

@Entity → “Esta clase es persistente”.
@Id → “Este atributo es la clave primaria”.
@Column → “Este atributo se corresponde con esta columna, y así se comporta”.

## Ventajas

1. Evita archivos de mapeo XML: todo se hace con anotaciones directamente en la clase.
2. Claridad y mantenibilidad: el mapeo está junto al código de la clase.
3. Flexibilidad: se pueden personalizar nombres de tablas, columnas y restricciones.  

## Resumen

Las anotaciones permiten que Hibernate entienda cómo almacenar y recuperar objetos Java desde la base de datos sin necesidad de escribir SQL o configuraciones externas.
