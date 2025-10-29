# Mapeo de Colecciones

Hibernate permite mapear colecciones Java (List, Set, Map, etc.) para representar relaciones o grupos de valores asociados a una entidad. Estas colecciones pueden contener:

1. Entidades relacionadas. Por ejemplo, una lista de pedidos de un cliente.
2. Tipos básicos o embebidos. Por ejemplo, una lista de teléfonos, etiquetas o direcciones.

## Tipos de colecciones admitidas

### 1. List

- Representa una colección ordenada que puede contener elementos repetidos.
- Hibernate genera una columna índice (para mantener el orden).
- Se usa cuando el orden de inserción o acceso es importante.

Ejemplo conceptual:  
Cliente
└── List Pedido pedidos

### 2. Set

- Representa una colección sin elementos duplicados.
- Hibernate no mantiene orden explícito.
- Es más eficiente cuando solo interesa la unicidad de los elemento

Ejemplo conceptual:
Persona
└── Set String correos

### 3. Map

- Permite almacenar pares clave-valor.
- Útil cuando se requiere asociar un valor a una clave específica (por ejemplo, configuración o preferencias).

Ejemplo conceptual:  
Usuario
└── Map String, String preferencias

## @ElementCollection

Cuando la colección no contiene entidades sino valores simples (como Strings o números),  
Hibernate permite mapearla con la anotación @ElementCollection.

### Concepto

- Se usa para colecciones de tipos básicos o embebidos.  
- Hibernate crea una tabla secundaria para almacenar los valores asociados a la entidad principal.  
- No requiere una entidad separada.

### Ejemplo conceptual

Empleado
└── List String habilidades

➡ Hibernate crea una tabla intermedia empleado_habilidades  
con columnas empleado_id y habilidad.

## Conceptos adicionales

### Carga (Fetching)

- Lazy (por defecto): la colección se carga solo al acceder a ella.  
- Eager: la colección se carga inmediatamente con la entidad principal.

### Cascada

- Si la colección contiene entidades, las operaciones (save, delete)  
  pueden propagarse usando cascade.

## Resumen conceptual

| Tipo de colección | Uso principal | Característica | Tabla auxiliar |
|-------------------|----------------|----------------|----------------|
| List | Elementos ordenados | Puede tener duplicados | Puede ser necesaria |
| Set | Elementos únicos | Sin orden | Puede ser necesaria |
| Map | Pares clave-valor | Acceso por clave | Puede ser necesaria |
| @ElementCollection | Tipos simples o embebidos | No son entidades | Sí (automática) |

En síntesis:
 El mapeo de colecciones permite representar grupos de elementos dentro de una entidad,  
 ya sean objetos relacionados o valores simples, manteniendo la estructura y semántica del modelo de objetos.
