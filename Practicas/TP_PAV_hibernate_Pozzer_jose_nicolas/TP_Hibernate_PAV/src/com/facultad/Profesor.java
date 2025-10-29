package com.facultad;

import java.util.Date;


public class Profesor extends Persona{
    private Integer antiguedad;

    public Profesor() {
    }

    public Profesor(Integer antiguedad, Integer dni, String apellido, String nombre, Date fecha_nacimiento, Ciudad unaCiudad) {
	super(dni, apellido, nombre, fecha_nacimiento, unaCiudad);
	this.antiguedad = antiguedad;
    }

    public Integer getAntiguedad() {
	return antiguedad;
    }

    public void setAntiguedad(Integer antiguedad) {
	this.antiguedad = antiguedad;
    }

    @Override
    public String toString() {
	return "Profesor{" +
	       "dni=" + getDni() +
	       ", apellido='" + getApellido() + '\'' +
	       ", nombre='" + getNombre() + '\'' +
	       ", fecha_nacimiento=" + getFecha_nacimiento() +
	       ", ciudad=" + (getUnaCiudad() != null ? getUnaCiudad().getNombre() : "N/A") +
	       ", antiguedad=" + antiguedad +
	       '}';
    }

}
