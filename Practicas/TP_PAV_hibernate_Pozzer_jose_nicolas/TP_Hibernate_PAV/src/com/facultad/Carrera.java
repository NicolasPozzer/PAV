
package com.facultad;

import java.util.ArrayList;
import java.util.List;

public class Carrera {
    private Integer id;
    private String nombre;
    private Facultad unaFacultad;
    private List<Materia> lista_materias = new ArrayList<Materia>();

    public Carrera() {
    }

    public Carrera(Integer id, String nombre, Facultad unaFacultad) {
	this.id = id;
	this.nombre = nombre;
	this.unaFacultad = unaFacultad;
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

    public Facultad getUnaFacultad() {
	return unaFacultad;
    }

    public void setUnaFacultad(Facultad unaFacultad) {
	this.unaFacultad = unaFacultad;
    }

    public List<Materia> getLista_materias() {
	return lista_materias;
    }

    public void setLista_materias(List<Materia> lista_materias) {
	this.lista_materias = lista_materias;
    }

    @Override
    public String toString() {
	return "Carrera{" + "id=" + id + ", nombre=" + nombre + ", unaFacultad=" + unaFacultad + ", lista_materias=" + lista_materias + '}';
    }
}
