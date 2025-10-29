
package com.facultad;

import java.util.Date;


public abstract class Persona {
    private Integer dni;
    private String apellido;
    private String nombre;
    private Date fecha_nacimiento;
    private Ciudad unaCiudad;

    public Persona() {
    }

    public Persona(Integer dni, String apellido, String nombre, Date fecha_nacimiento, Ciudad unaCiudad) {
	this.dni = dni;
	this.apellido = apellido;
	this.nombre = nombre;
	this.fecha_nacimiento = fecha_nacimiento;
	this.unaCiudad = unaCiudad;
    }

    public Integer getDni() {
	return dni;
    }

    public void setDni(Integer dni) {
	this.dni = dni;
    }

    public String getApellido() {
	return apellido;
    }

    public void setApellido(String apellido) {
	this.apellido = apellido;
    }

    public String getNombre() {
	return nombre;
    }

    public void setNombre(String nombre) {
	this.nombre = nombre;
    }

    public Date getFecha_nacimiento() {
	return fecha_nacimiento;
    }

    public void setFecha_nacimiento(Date fecha_nacimiento) {
	this.fecha_nacimiento = fecha_nacimiento;
    }

    public Ciudad getUnaCiudad() {
	return unaCiudad;
    }

    public void setUnaCiudad(Ciudad unaCiudad) {
	this.unaCiudad = unaCiudad;
    }

    @Override
    public String toString() {
	return "Persona{" + "dni=" + dni + ", apellido=" + apellido + ", nombre=" + nombre + ", fecha_nacimiento=" + fecha_nacimiento + ", unaCiudad=" + unaCiudad + '}';
    }
}
