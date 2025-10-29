
package com.facultad;


public class Facultad {
    private Integer id;
    private String nombre;
    private Facultad unaCiudad;

    public Facultad() {
    }

    public Facultad(Integer id, String nombre, Facultad unaCiudad) {
	this.id = id;
	this.nombre = nombre;
	this.unaCiudad = unaCiudad;
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

    public Facultad getUnaCiudad() {
	return unaCiudad;
    }

    public void setUnaCiudad(Facultad unaCiudad) {
	this.unaCiudad = unaCiudad;
    }

    @Override
    public String toString() {
	return "Facultad{" + "id=" + id + ", nombre=" + nombre + ", unaCiudad=" + unaCiudad + '}';
    }
    
    
}
