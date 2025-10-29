
package com.facultad;

import java.util.Date;


public class Alumno extends Persona{
    private Integer nro_legajo;
    private String anio_ingreso;

    public Alumno() {
    }

    public Alumno(Integer nro_legajo, String anio_ingreso, Integer dni, String apellido, String nombre, Date fecha_nacimiento, Ciudad unaCiudad) {
	super(dni, apellido, nombre, fecha_nacimiento, unaCiudad);
	this.nro_legajo = nro_legajo;
	this.anio_ingreso = anio_ingreso;
    }

    public Integer getNro_legajo() {
	return nro_legajo;
    }

    public void setNro_legajo(Integer nro_legajo) {
	this.nro_legajo = nro_legajo;
    }

    public String getAnio_ingreso() {
	return anio_ingreso;
    }

    public void setAnio_ingreso(String anio_ingreso) {
	this.anio_ingreso = anio_ingreso;
    }

    @Override
    public String toString() {
	return "Alumno{" +
	       "dni=" + getDni() +
	       ", apellido='" + getApellido() + '\'' +
	       ", nombre='" + getNombre() + '\'' +
	       ", fecha_nacimiento=" + getFecha_nacimiento() +
	       ", ciudad=" + (getUnaCiudad() != null ? getUnaCiudad().getNombre() : "N/A") +
	       ", nro_legajo=" + nro_legajo +
	       ", anio_ingreso='" + anio_ingreso + '\'' +
	       '}';
    }

}
