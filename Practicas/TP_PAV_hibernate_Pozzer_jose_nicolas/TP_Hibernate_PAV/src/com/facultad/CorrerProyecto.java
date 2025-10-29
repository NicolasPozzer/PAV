package com.facultad;

import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/**
 *
 * @author Grupo PAV
 */
public class CorrerProyecto {

    public static void main(String[] args) {

	java.util.logging.Logger.getLogger("org.hibernate").setLevel(java.util.logging.Level.ALL);
	SessionFactory sf = new Configuration().configure().buildSessionFactory();

	/* IMPORTANTEEE! */
	// Cargar datos de prueba (SOLO EJECUTAR ESTA FUNCION LA PRIMERA VEZ, PARA POBLAR LA DB)
	//CargarDatosEjemplo(sf);
	
	// Probar los métodos
	ObtenerAlumnosOrdenadosPorApellido(sf);
	ObtenerProfesoresOrdenadosPorAntiguedad(sf);
	ObtenerMateriasPorNivel(sf, 2);
	
	//test metodos CRUD (Crear, Leer, Actualizar, Borrar)
	//EliminarAlumno(sf,42579253);

	//ListarAlumnos(sf);
	//ListarProfesores(sf);
	//ListarMaterias(sf);
	//ListarCarreras(sf);

	sf.close();
    }

    /* ==============================================
    * Obtener Alumnos Ordenados Por su Apellido
    * ============================================== */
    public static void ObtenerAlumnosOrdenadosPorApellido(SessionFactory sf) {
	Session session = sf.openSession();
	Transaction trx = session.beginTransaction();

	List<Alumno> alumnos = session.createQuery("FROM Alumno ORDER BY apellido ASC").list();

	System.out.println("\n================================================");
	System.out.println("LISTADO DE ALUMNOS ORDENADOS POR APELLIDO (A-Z)");
	System.out.println("================================================");

	for (Alumno alumno : alumnos) {
	    System.out.print("DNI: " + alumno.getDni() + "  ");
	    System.out.print("Apellido y Nombre: " + alumno.getApellido() + " " + alumno.getNombre() + "  ");
	    System.out.print("Fecha de nacimiento: " + alumno.getFecha_nacimiento() + "  ");
	    System.out.print("Ciudad: " + alumno.getUnaCiudad().getNombre() + "  ");
	    System.out.print("N° Legajo: " + alumno.getNro_legajo() + "  ");
	    System.out.print("Año de ingreso: " + alumno.getAnio_ingreso() + "  ");
	    System.out.println("\n");
	}
	System.out.println("\n--------------------------------------------------------------------------------------------\n\n");

	trx.commit();
	session.close();
    }

    /* ==============================================
    * Obtener Profes Ordenados Por su Antiguedad
    * ============================================== */
    private static void ObtenerProfesoresOrdenadosPorAntiguedad(SessionFactory sf) {
	Session session = sf.openSession();
	Transaction trx = session.beginTransaction();

	List<Profesor> profesores = session.createQuery("FROM Profesor ORDER BY antiguedad DESC").list();

	System.out.println("\n==================================================================");
	System.out.println("LISTADO DE PROFESORES ORDENADOS POR ANTIGUEDAD (MAYOR A MENOR)");
	System.out.println("==================================================================");

	for (Profesor profesor : profesores) {
	    System.out.print("Años de antigüedad: " + profesor.getAntiguedad() + "  ");
	    System.out.print("DNI: " + profesor.getDni() + "  ");
	    System.out.print("Nombre: " + profesor.getNombre() + " " + profesor.getApellido() + "  ");
	    System.out.print("Fecha de nacimiento: " + profesor.getFecha_nacimiento() + "  ");
	    System.out.print("Ciudad: " + profesor.getUnaCiudad().getNombre() + "  ");
	    System.out.println("\n");
	}
	System.out.println("\n--------------------------------------------------------------------------------------------\n\n");

	trx.commit();
	session.close();
    }

    /* ====================================================================
    * Obtener Materias Por su Nivel (elegido por parámetro)
    * ==================================================================== */
    private static void ObtenerMateriasPorNivel(SessionFactory sf, Integer nivel) {
	Session session = sf.openSession();
	Transaction trx = session.beginTransaction();

	Query query = session.createQuery("FROM Materia WHERE nivel = :nivel");
	query.setParameter("nivel", nivel);
	List<Materia> materias = query.list();

	System.out.println("\n==============================================");
	System.out.println("LISTADO DE MATERIAS DEL NIVEL " + nivel);
	System.out.println("==============================================");

	if (materias.isEmpty()) {
	    System.out.println("No se encontraron materias para el nivel " + nivel);
	} else {
	    for (Materia materia : materias) {
		System.out.print("Materia: " + materia.getNombre() + "  ");
		System.out.print("Nivel: " + materia.getNivel() + "  ");
		System.out.print("Profesor: " + materia.getUnProfesor().getNombre() + " " + materia.getUnProfesor().getApellido() + "  ");
		System.out.println("\n");
	    }
	    System.out.println("\n--------------------------------------------------------------------------------------------\n\n");
	}

	trx.commit();
	session.close();
    }
    
    

    /* ==============================================
     * MÉTODOS CRUD MATERIA
     * ============================================== */
    public static void GuardarMateria(SessionFactory sf, Materia materia) {
	Session session = sf.openSession();
	Transaction trx = session.beginTransaction();
	session.save(materia);
	trx.commit();
	session.close();
    }

    public static void ActualizarMateria(SessionFactory sf, Materia materia) {
	Session session = sf.openSession();
	Transaction trx = session.beginTransaction();
	session.update(materia);
	trx.commit();
	session.close();
    }

    public static void EliminarMateria(SessionFactory sf, Integer id_materia) {
	Session session = sf.openSession();
	Transaction trx = session.beginTransaction();
	Materia materia = (Materia) session.load(Materia.class, id_materia);
	session.delete(materia);
	trx.commit();
	session.close();
    }

    public static void ListarMaterias(SessionFactory sf) {
	Session session = sf.openSession();
	Transaction trx = session.beginTransaction();
	List<Materia> materias = session.createQuery("From Materia").list();
	for (Materia materia : materias) {
	    System.out.println(materia.toString());
	}
	trx.commit();
	session.close();
    }

    /* ==============================================
     * MÉTODOS CRUD CIUDAD
     * ============================================== */
    public static void GuardarCiudad(SessionFactory sf, Ciudad ciudad) {
	Session session = sf.openSession();
	Transaction trx = session.beginTransaction();
	session.save(ciudad);
	trx.commit();
	session.close();
    }

    public static void ActualizarCiudad(SessionFactory sf, Ciudad ciudad) {
	Session session = sf.openSession();
	Transaction trx = session.beginTransaction();
	session.update(ciudad);
	trx.commit();
	session.close();
    }

    public static void EliminarCiudad(SessionFactory sf, Integer id_ciudad) {
	Session session = sf.openSession();
	Transaction trx = session.beginTransaction();
	Ciudad ciudad = (Ciudad) session.load(Ciudad.class, id_ciudad);
	session.delete(ciudad);
	trx.commit();
	session.close();
    }

    public static void ListarCiudades(SessionFactory sf) {
	Session session = sf.openSession();
	Transaction trx = session.beginTransaction();
	List<Ciudad> ciudades = session.createQuery("FROM Ciudad").list();
	for (Ciudad ciudad : ciudades) {
	    System.out.println(ciudad.toString());
	}
	trx.commit();
	session.close();
    }

    /* ==============================================
     * MÉTODOS CRUD ALUMNO
     * ============================================== */
    public static void GuardarAlumno(SessionFactory sf, Alumno alumno) {
	Session session = sf.openSession();
	Transaction trx = session.beginTransaction();
	session.save(alumno);
	trx.commit();
	session.close();
    }

    public static void ActualizarAlumno(SessionFactory sf, Alumno alumno) {
	Session session = sf.openSession();
	Transaction trx = session.beginTransaction();
	session.update(alumno);
	trx.commit();
	session.close();
    }

    public static void EliminarAlumno(SessionFactory sf, Integer dni) {
	Session session = sf.openSession();
	Transaction trx = session.beginTransaction();
	Alumno alumno = (Alumno) session.load(Alumno.class, dni);
	session.delete(alumno);
	trx.commit();
	session.close();
    }

    public static void ListarAlumnos(SessionFactory sf) {
	Session session = sf.openSession();
	Transaction trx = session.beginTransaction();
	List<Alumno> alumnos = session.createQuery("FROM Alumno").list();
	for (Alumno alumno : alumnos) {
	    System.out.println(alumno.toString());
	}
	trx.commit();
	session.close();
    }

    /* ==============================================
     * MÉTODOS CRUD PROFESOR
     * ============================================== */
    public static void GuardarProfesor(SessionFactory sf, Profesor profesor) {
	Session session = sf.openSession();
	Transaction trx = session.beginTransaction();
	session.save(profesor);
	trx.commit();
	session.close();
    }

    public static void ActualizarProfesor(SessionFactory sf, Profesor profesor) {
	Session session = sf.openSession();
	Transaction trx = session.beginTransaction();
	session.update(profesor);
	trx.commit();
	session.close();
    }

    public static void EliminarProfesor(SessionFactory sf, Integer dni) {
	Session session = sf.openSession();
	Transaction trx = session.beginTransaction();
	Profesor profesor = (Profesor) session.load(Profesor.class, dni);
	session.delete(profesor);
	trx.commit();
	session.close();
    }

    public static void ListarProfesores(SessionFactory sf) {
	Session session = sf.openSession();
	Transaction trx = session.beginTransaction();
	List<Profesor> profesores = session.createQuery("FROM Profesor").list();
	for (Profesor profesor : profesores) {
	    System.out.println(profesor.toString());
	}
	trx.commit();
	session.close();
    }

    /* ==============================================
     * MÉTODOS CRUD FACULTAD
     * ============================================== */
    public static void GuardarFacultad(SessionFactory sf, Facultad facultad) {
	Session session = sf.openSession();
	Transaction trx = session.beginTransaction();
	session.save(facultad);
	trx.commit();
	session.close();
    }

    public static void ActualizarFacultad(SessionFactory sf, Facultad facultad) {
	Session session = sf.openSession();
	Transaction trx = session.beginTransaction();
	session.update(facultad);
	trx.commit();
	session.close();
    }

    public static void EliminarFacultad(SessionFactory sf, Integer id_facultad) {
	Session session = sf.openSession();
	Transaction trx = session.beginTransaction();
	Facultad facultad = (Facultad) session.load(Facultad.class, id_facultad);
	session.delete(facultad);
	trx.commit();
	session.close();
    }

    public static void ListarFacultades(SessionFactory sf) {
	Session session = sf.openSession();
	Transaction trx = session.beginTransaction();
	List<Facultad> facultades = session.createQuery("FROM Facultad").list();
	for (Facultad facultad : facultades) {
	    System.out.println(facultad.toString());
	}
	trx.commit();
	session.close();
    }

    /* ==============================================
     * MÉTODOS CRUD CARRERA
     * ============================================== */
    public static void GuardarCarrera(SessionFactory sf, Carrera carrera) {
	Session session = sf.openSession();
	Transaction trx = session.beginTransaction();
	session.save(carrera);
	trx.commit();
	session.close();
    }

    public static void ActualizarCarrera(SessionFactory sf, Carrera carrera) {
	Session session = sf.openSession();
	Transaction trx = session.beginTransaction();
	session.update(carrera);
	trx.commit();
	session.close();
    }

    public static void EliminarCarrera(SessionFactory sf, Integer id_carrera) {
	Session session = sf.openSession();
	Transaction trx = session.beginTransaction();
	Carrera carrera = (Carrera) session.load(Carrera.class, id_carrera);
	session.delete(carrera);
	trx.commit();
	session.close();
    }

    public static void ListarCarreras(SessionFactory sf) {
	Session session = sf.openSession();
	Transaction trx = session.beginTransaction();
	List<Carrera> carreras = session.createQuery("FROM Carrera").list();
	for (Carrera carrera : carreras) {
	    System.out.println(carrera.toString());
	}
	trx.commit();
	session.close();
    }

    /* ==============================================
     * MÉTODO PARA CARGAR DATOS DE PRUEBA
     * ============================================== */
    public static void CargarDatosEjemplo(SessionFactory sf) {
	Session session = sf.openSession();
	Transaction trx = session.beginTransaction();

	// Ciudades
	Ciudad c1 = new Ciudad(null, "Buenos Aires");
	Ciudad c2 = new Ciudad(null, "Cordoba");
	Ciudad c3 = new Ciudad(null, "Chaco");
	session.save(c1);
	session.save(c2);
	session.save(c3);

	// Profesores
	Profesor p1 = new Profesor(10, 23436545, "Lopez", "Maria", new java.util.Date(80, 3, 12), c1);
	Profesor p2 = new Profesor(5, 27329945, "Garcia", "Juan", new java.util.Date(85, 10, 25), c2);
	session.save(p1);
	session.save(p2);

	// Alumnos
	Alumno a1 = new Alumno(1234, "2022", 42579253, "Perez", "Lucas", new java.util.Date(102, 4, 15), c1);
	Alumno a2 = new Alumno(1235, "2021", 41534553, "Martinez", "Ana", new java.util.Date(101, 7, 8), c2);
	Alumno a3 = new Alumno(1236, "2023", 42333211, "Suarez", "Diego", new java.util.Date(103, 2, 20), c2);
	session.save(a1);
	session.save(a2);
	session.save(a3);

	// Materias
	Materia m1 = new Materia(null, "Programacion Avanzada", 1, p1);
	m1.getLista_alumnos().add(a1);
	m1.getLista_alumnos().add(a2);

	Materia m2 = new Materia(null, "Base de Datos", 2, p2);
	m2.getLista_alumnos().add(a2);
	m2.getLista_alumnos().add(a3);

	session.save(m1);
	session.save(m2);

	// Facultad
	Facultad f1 = new Facultad(1, "Facultad de Ingenieria", null);
	f1.setUnaCiudad(f1);
	session.save(f1);

	// Carrera
	Carrera carrera1 = new Carrera(null, "Ingenieria en Sistemas", f1);
	carrera1.getLista_materias().add(m1);
	carrera1.getLista_materias().add(m2);
	session.save(carrera1);

	trx.commit();
	session.close();

	System.out.println("Datos de ejemplo cargados correctamente.");
    }
}
