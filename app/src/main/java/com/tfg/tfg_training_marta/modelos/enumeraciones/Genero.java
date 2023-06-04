package com.tfg.tfg_training_marta.modelos.enumeraciones;

public enum Genero {
    NONE("Ninguno"),
    MUJER("Mujer"),
    HOMBRE("Hombre"),
    OTROS("Otros"),
    PREFIERO_NO_DECIRLO("Prefiero no decirlo");

    private String friendlyName;


    private Genero(String friendlyName){
        this.friendlyName = friendlyName;
    }

    @Override
    public String toString() {
        return friendlyName;
    }
}
