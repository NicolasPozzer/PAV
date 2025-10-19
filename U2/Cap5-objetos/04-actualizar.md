# Actualizar: update() y merge()

Sirven para sincronizar los cambios de un objeto con la base de datos. Cuando se cuenta con un objeto almacenado, lo modificamos en memoria, y se desea reflejar ese cambio en la base de datos.

1. update() se usa cuando el objeto ya pertenece a la sesión actual (es decir, Hibernate lo está gestionando). Si el objeto proviene de otra sesión, puede causar errores de duplicación.

2. merge() es más flexible: combina el estado del objeto modificado (aunque esté fuera de la sesión) con la versión persistente que Hibernate conoce. Es el método recomendado en la mayoría de los casos modernos.
