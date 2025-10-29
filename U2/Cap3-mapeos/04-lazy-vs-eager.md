# Lazy vs Eager Loading en Hibernate

Cuando tenemos asociaciones entre entidades (por ejemplo, una relación @OneToMany entre Cliente y Pedido), Hibernate necesita decidir cuándo cargar los datos relacionados desde la base de datos.

## Existen dos estrategias principales

1. EAGER
    Carga inmediata. Al obtener la entidad principal
2. LAZY
    Carga diferida. Solo cuando realmente se accede al atributo asociado.
