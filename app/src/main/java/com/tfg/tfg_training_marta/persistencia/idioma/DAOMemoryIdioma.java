package com.tfg.tfg_training_marta.persistencia.idioma;

import com.tfg.tfg_training_marta.persistencia.contexto.DataMemory;

import java.util.List;

public class DAOMemoryIdioma extends IDAOIdioma{

    private DataMemory context;
    public DAOMemoryIdioma() {
        this.context =DataMemory.getInstance();
    }
    @Override
    public Object getById(String id) {
        return null;
    }

    @Override
    public List getAll() {
        return context.Idiomas;
    }

    @Override
    public boolean update(Object model) {
        return false;
    }

    @Override
    public boolean delete(Object model) {
        return false;
    }

    @Override
    public boolean add(Object model) {
        return false;
    }
}
