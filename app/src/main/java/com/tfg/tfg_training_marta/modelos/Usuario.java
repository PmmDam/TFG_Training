package com.tfg.tfg_training_marta.modelos;

import com.tfg.tfg_training_marta.modelos.enumeraciones.Genero;

public class Usuario {

    //Propiedades
    private String id;
    private String email;
    private Genero genero;
    private String pass;
    private String nombre;
    private String apellido;
    private String tlfn;

    //Constructor
    public Usuario(String id, String email, Genero genero, String pass, String nombre, String apellido, String tlfn) {
        this.id = id;
        this.email = email;
        this.genero = genero;
        this.pass = pass;
        this.nombre = nombre;
        this.apellido = apellido;
        this.tlfn = tlfn;
    }

    public Usuario() {}

    //Meéodos
    @Override
    public String toString() {
        return "Usuario{" +
                "id='" + id + '\'' +
                ", email='" + email + '\'' +
                ", genero=" + genero +
                ", pass='" + pass + '\'' +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", tlfn='" + tlfn + '\'' +
                '}';
    }

    //Getters & Setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Genero getGenero() {
        return genero;
    }

    public void setGenero(Genero genero) {
        this.genero = genero;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
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

    public String getTlfn() {
        return tlfn;
    }

    public void setTlfn(String tlfn) {
        this.tlfn = tlfn;
    }
}
