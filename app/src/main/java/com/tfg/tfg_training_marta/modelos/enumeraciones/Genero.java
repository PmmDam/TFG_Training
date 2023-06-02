package com.tfg.tfg_training_marta.modelos.enumeraciones;

public enum Genero {
    NONE("Ninguno"),
    MUJER("Mujer"),
    HOMBRE("Hombre"),
    OTROS("Otros"),
    PREFIERO_NO_DECIRLO("Prefiero no decirlo");

    private String name;

    private Genero(String name){
        this.name = name;
    }

}
