package com.tfg.tfg_training_marta.modelos;

import com.google.firebase.Timestamp;
import com.tfg.tfg_training_marta.modelos.enumeraciones.TipoEntrenamiento;

import java.util.ArrayList;
import java.util.List;

public class Entrenamiento {

    //Propiedades
    private String id;
    private String titulo;
    private String youtubeVidUrl;
    private String pdfRuta;
    private List<String> ejerciciosId = new ArrayList<>();


    public Entrenamiento(String id, String titulo, String youtubeVidUrl, String pdfRuta, List<String> ejerciciosId) {
        this.id = id;
        this.titulo = titulo;
        this.youtubeVidUrl = youtubeVidUrl;
        this.pdfRuta = pdfRuta;
        this.ejerciciosId = ejerciciosId;
    }

    public Entrenamiento() {
    }

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

    public String getYoutubeVidUrl() {
        return youtubeVidUrl;
    }

    public void setYoutubeVidUrl(String youtubeVidUrl) {
        this.youtubeVidUrl = youtubeVidUrl;
    }

    public String getPdfRuta() {
        return pdfRuta;
    }

    public void setPdfRuta(String pdfRuta) {
        this.pdfRuta = pdfRuta;
    }

    public List<String> getEjerciciosId() {
        return ejerciciosId;
    }

    public void setEjerciciosId(List<String> ejerciciosId) {
        this.ejerciciosId = ejerciciosId;
    }
}
