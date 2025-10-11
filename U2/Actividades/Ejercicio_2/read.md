# Persistencia de Datos

Vencimiento jueves, 30 de octubre de 2025, 23:59
Actividad de resolución grupal (de 4 a 5 alumnos cada grupo).
El objetivo de la misma es poner en práctica los conceptos aprendidos en la Unidad Persistencia de datos - Hibernate y subcapítulos que la componen.
El formato de entrega debe ser zip, habiendo utilizado Netbeans 8.2 y colocando dentro archivo.txt con el apellido y nombre de los integrantes del grupo.
Debe ser entregada por todos los alumnos para su calificación.
Cualquier consulta pueden remitirla a través del foro de la Unidad de forma de darle respuesta lo antes posible.

1. Persistir el siguiente modelo orientado a objetos:

    Paquete
    com.facultad

    Clase Ciudad
    Nombre

    Clase Persona
    Apellido
    Nombre
    Dni
    Fecha de nacimiento
    Ciudad

    Clase Alumno extiende de Persona
    Numero de legajo
    Año de ingreso

    Clase Profesor extiende de Persona
    Antigüedad

    Materia
    Nombre
    Nivel
    Profesor
    Colección de alumnos

    Facultad
    Nombre
    Ciudad

    Carrera
    Nombre
    Facultad
    Colección de Materias

2. Clases
    Implementar los constructores que se consideren necesarios teniendo en cuenta que:
    1. Constructor por defecto
    2. Constructor usando todos los atributos
    3. Sobreescribir el método ToString para mostrar todos los atributos de la clase

3. Consultas:
    Implementar las consultas HQL
    obtener todos los alumnos ordenados por Apellido
    obtener todos los profesores ordenados por Antigüedad
    obtener todas las materias de un Nivel pasado como parámetro

4. Para cada clase crear un método que permita:
    1. Crear una instancia
    2. Actualizar una instancia
    3. Borrar una instancia
    4. Listar todos los elementos
