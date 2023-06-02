package com.tfg.tfg_training_marta.modelos;

import java.util.ArrayList;
import java.util.List;

public class Ejercicio {

    //Propiedades
    private String id;
    private String titulo;
    private int series;
    private int duracion;
    private int repeticiones;
    private List<String> imagenesId = new ArrayList<>();


    //Contructor
    public Ejercicio(String id, String titulo, int series, int duracion, int repeticiones, List<String> imagenesId) {
        this.id = id;
        this.titulo = titulo;
        this.series = series;
        this.duracion = duracion;
        this.repeticiones = repeticiones;
        this.imagenesId = imagenesId;

    }

    //Constructor por defecto
    public Ejercicio() {}

    //Getters & Setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getSeries() {
        return series;
    }

    public void setSeries(int series) {
        this.series = series;
    }

    public int getDuracion() {
        return duracion;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }

    public int getRepeticiones() {
        return repeticiones;
    }

    public void setRepeticiones(int repeticiones) {
        this.repeticiones = repeticiones;
    }

    public List<String> getImagenesId() {
        return imagenesId;
    }

    public void setImagenesId(List<String> imagenesId) {
        this.imagenesId = imagenesId;
    }


}
