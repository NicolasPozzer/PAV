# Manejo de transacciones (Transaction)

En Hibernate, la transacción es la unidad que asegura que un conjunto de operaciones sobre la base de datos se ejecute de manera atómica y consistente. Se utiliza para garantizar que los cambios realizados por la aplicación sean seguros y coherentes.

Una transacción agrupa operaciones (guardar, actualizar, eliminar) en una sola unidad de trabajo.

## Regla ACID

    1. Atomaticidad: todo se ejecuta o nada se ejecuta.
    2. Consistencia: la base pasa de un estado válido a otro válido.
    3. Isolamiento: las transacciones concurrentes no interfieren entre sí.
    4. Durabilidad: los cambios confirmados se mantienen aunque falle el sistema.

## Flujo

1. Abrir una Session.
2. Iniciar una Transaction.
3. Realizar operaciones CRUD sobre los objetos persistentes.
4. Confirmar la transacción con commit para aplicar los cambios en la base de datos.
5. Si ocurre un error, revertir con rollback para deshacer todos los cambios de la transacción.
6. Cerrar la Session al finalizar.

La Transaction es la “garantía de seguridad y coherencia” de los cambios en la base de datos. Aunque hagas múltiples operaciones dentro de la misma transacción, Hibernate asegura que o todas se aplican o ninguna. Permite manejar errores y conflictos de manera controlada.
