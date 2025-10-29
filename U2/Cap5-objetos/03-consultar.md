# Consultar | get() y load()

Se utilizan para recuperar datos desde la base de datos y convertirlos en objetos Java.

1. get() busca un objeto por su identificador. Si no lo encuentra, devuelve null.
2. load() también busca por id, pero devuelve un proxy (un objeto intermedio). Si se accede a un objeto que no existe, lanza una excepción.

En la práctica

get() es más seguro cuando no estamos seguros de que el objeto exista.
load() es más eficiente cuando solo necesitamos una referencia (por ejemplo, para borrar o relacionar objetos sin cargarlos completamente).
