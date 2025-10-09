# Stack

1. Java (JDK) 8: compatibilidad con NetBeans 8.2 y con Hibernate 4.3.1

2. Hibernate (ORM) 4.3.1. Final Versión estable compatible con JDK 8; requiere `MySQL Connector/J 8.0.x`

3. MySQL: (Base de datos) 8.0 Ejecutado en contenedor Docker; base pav_hibernate

4. Docker: Última versión estable Usado para levantar el contenedor MySQL con: docker run -d --name mysql8 -e MYSQL_ROOT_PASSWORD=MyStrongPassw0rd -p 3306:3306 mysql:8.0

5. NetBeans Apache NetBeans 26

6. VS Code + SQLTools

7. JDBC Compatible con JDK 8 + MySQL Connector/J 8.0.x Usado en el método JDBCExample para comparar con Hibernate
