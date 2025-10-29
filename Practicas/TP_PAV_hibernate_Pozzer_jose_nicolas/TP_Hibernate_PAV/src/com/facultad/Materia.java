
package com.facultad;
import java.util.ArrayList;
import java.util.List;


public class Materia {
    private Integer id;
    private String nombre;
    private Integer nivel;
    private Profesor unProfesor;
    private List<Alumno> lista_alumnos = new ArrayList<Alumno>();

    public Materia() {
    }

    public Materia(Integer id, String nombre, Integer nivel, Profesor unProfesor) {
	this.id = id;
	this.nombre = nombre;
	this.nivel = nivel;
	this.unProfesor = unProfesor;
    }

    public Integer getId() {
	return id;
    }

    public void setId(Integer id) {
	this.id = id;
    }

    public String getNombre() {
	return nombre;
    }

    public void setNombre(String nombre) {
	this.nombre = nombre;
    }

    public Integer getNivel() {
	return nivel;
    }

    public void setNivel(Integer nivel) {
	this.nivel = nivel;
    }

    public Profesor getUnProfesor() {
	return unProfesor;
    }

    public void setUnProfesor(Profesor unProfesor) {
	this.unProfesor = unProfesor;
    }

    public List<Alumno> getLista_alumnos() {
	return lista_alumnos;
    }

    public void setLista_alumnos(List<Alumno> lista_alumnos) {
	this.lista_alumnos = lista_alumnos;
    }

    @Override
    public String toString() {
	return "Materia{" + "id=" + id + ", nombre=" + nombre + ", nivel=" + nivel + ", unProfesor=" + unProfesor + ", lista_alumnos=" + lista_alumnos + '}';
    }
    
}

