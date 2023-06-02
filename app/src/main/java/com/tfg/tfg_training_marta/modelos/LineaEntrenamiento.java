package com.tfg.tfg_training_marta.modelos;

import com.google.firebase.Timestamp;
import com.tfg.tfg_training_marta.modelos.enumeraciones.TipoEntrenamiento;

public class LineaEntrenamiento {

    private String usuarioId;
    private String entrenamientoId;
    private int duracionTotalAproxMin;
    private Timestamp fechaInicio;
    private boolean completado;
    private TipoEntrenamiento tipoEntrenamiento = TipoEntrenamiento.OBLIGATORIO;

    public LineaEntrenamiento(String usuarioId, String entrenamientoId, int duracionTotalAproxMin, Timestamp fechaInicio, boolean completado,TipoEntrenamiento tipoEntrenamiento) {
        this.usuarioId = usuarioId;
        this.entrenamientoId = entrenamientoId;
        this.duracionTotalAproxMin = duracionTotalAproxMin;
        this.fechaInicio = fechaInicio;
        this.completado = completado;
        this.tipoEntrenamiento = tipoEntrenamiento;
    }

    public LineaEntrenamiento() {
    }

    public String getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(String usuarioId) {
        this.usuarioId = usuarioId;
    }

    public String getEntrenamientoId() {
        return entrenamientoId;
    }

    public void setEntrenamientoId(String entrenamientoId) {
        this.entrenamientoId = entrenamientoId;
    }

    public int getDuracionTotalAproxMin() {
        return duracionTotalAproxMin;
    }

    public void setDuracionTotalAproxMin(int duracionTotalAproxMin) {
        this.duracionTotalAproxMin = duracionTotalAproxMin;
    }

    public Timestamp getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Timestamp fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public boolean isCompletado() {
        return completado;
    }

    public void setCompletado(boolean completado) {
        this.completado = completado;
    }

    public TipoEntrenamiento getTipoEntrenamiento() {
        return tipoEntrenamiento;
    }

    public void setTipoEntrenamiento(TipoEntrenamiento tipoEntrenamiento) {
        this.tipoEntrenamiento = tipoEntrenamiento;
    }
}
