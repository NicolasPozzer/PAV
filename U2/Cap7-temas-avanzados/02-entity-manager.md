# EntityManager | Integración con JPA

JPA (Java Persistence API) es una especificación estándar de Java para el manejo de persistencia (ORM). Hibernate es una implementación de esa especificación. En otras palabras: JPA define las reglas. Hibernate las implementa y agrega funcionalidades adicionales.

El uso de EntityManager (definido por JPA) reemplaza a Session (propio de Hibernate), pero el comportamiento es muy similar. Esto permite que el código sea más portátil, ya que podría usarse otro proveedor JPA (como EclipseLink) sin grandes cambios.

Independencia del proveedor: Se puede cambiar de Hibernate a otro motor de persistencia sin reescribir toda la lógica.
