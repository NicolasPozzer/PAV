# Marcas

1. Consigna
    1. Modelar una clase Java (Marca) que representa una entidad de base de datos.
    2. Persistir esa entidad en MySQL usando dos métodos:
        1. JDBC: conexión directa, manual, con SQL escrito a mano.
        2. Hibernate: framework ORM que se encarga de mapear objetos Java a tablas SQL automáticamente.
    3. Validar que los datos se insertan y se pueden consultar desde Java.

2. Marca.java
    Es la clase modelo.
    Tiene atributos id, codigo, descripcion.
    Incluye constructor, getters/setters y toString().

3. Marca.hbm.xml
    Es el archivo de mapeo de Hibernate.
    Le dice a Hibernate cómo convertir objetos Marca en registros de la tabla marca.
    Define el nombre de la tabla, los campos, el tipo de datos y el generador de ID.

4. Clase1.java
    Tiene dos métodos
    1. JDBCExample: crea la tabla Marcas, inserta una fila y la consulta usando SQL manual.
    2. HibernateExample: usa Hibernate para guardar una instancia de Marca y luego consulta todas las marcas.

5. log
    Mensaje Significado
    INFO: Configuring from resource: /hibernate.cfg.xml Hibernate está leyendo tu configuración
    INFO: Reading mappings from resource: clase1/Marca.hbm.xml Está cargando el mapeo de la clase Marca
    INFO: Table not found: marca La tabla no existía, así que Hibernate la va a crear
    INFO: Schema update complete El esquema fue actualizado (tabla creada)
    Hibernate: insert into marca... Se ejecutó el INSERT
    Hibernate: select ... from marca Se ejecutó el SELECT
    Marca{id=1, codigo=M1, descripcion=Marca1} Se imprimió el objeto recuperado
