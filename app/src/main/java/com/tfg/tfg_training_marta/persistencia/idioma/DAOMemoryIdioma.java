package com.tfg.tfg_training_marta.persistencia.idioma;

import com.tfg.tfg_training_marta.modelos.Idioma;
import com.tfg.tfg_training_marta.persistencia.contexto.DataMemory;

import java.util.ArrayList;
import java.util.List;

public class DAOMemoryIdioma extends IDAOIdioma{

    private DataMemory context;
    public DAOMemoryIdioma() {
        this.context =DataMemory.getInstance();
    }
    @Override
    public Idioma getById(String id) {
        return null;
    }

    @Override
    public List<Idioma> getAll() {
        return context.Idiomas;
    }

    @Override
    public boolean update(Idioma model) {
        return false;
    }

    @Override
    public boolean delete(Idioma model) {
        return false;
    }

    @Override
    public boolean add(Idioma model) {
        return false;
    }
}
