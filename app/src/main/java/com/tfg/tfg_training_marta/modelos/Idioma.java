package com.tfg.tfg_training_marta.modelos;

public class Idioma {
    //Properties
    private String id;
    private String countryCode;
    private String description;

    public Idioma(String id, String countryCode, String description) {
        this.id = id;
        this.countryCode = countryCode;
        this.description = description;
    }

    public Idioma() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
