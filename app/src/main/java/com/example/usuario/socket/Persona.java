package com.example.usuario.socket;

import java.io.Serializable;

/**
 * Created by Usuario on 04/04/2018.
 */

public class Persona implements Serializable{
    private double numeroSocio;
    private String nombre;
    private String apellido;
    private static final Long serialVersionUID=1L;

    public Persona() {
    }

    public Persona(String nombre, String apellido) {
        this.nombre = nombre;
        this.apellido = apellido;
    }

    public Persona(String nombre, String apellido, double numeroSocio) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.numeroSocio = numeroSocio;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public double getNumeroSocio() {
        return numeroSocio;
    }

    public void setNumeroSocio(double numeroSocio) {
        this.numeroSocio = numeroSocio;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Persona persona = (Persona) o;

        if (Double.compare(persona.numeroSocio, numeroSocio) != 0) return false;
        if (nombre != null ? !nombre.equals(persona.nombre) : persona.nombre != null) return false;
        return apellido != null ? apellido.equals(persona.apellido) : persona.apellido == null;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        temp = Double.doubleToLongBits(numeroSocio);
        result = (int) (temp ^ (temp >>> 32));
        result = 31 * result + (nombre != null ? nombre.hashCode() : 0);
        result = 31 * result + (apellido != null ? apellido.hashCode() : 0);
        return result;
    }
}
