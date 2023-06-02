package com.tfg.tfg_training_marta.persistencia.entrenamientos;

import com.tfg.tfg_training_marta.modelos.Entrenamiento;
import com.tfg.tfg_training_marta.persistencia.contexto.DataMemory;

import java.util.List;

public class DAOMemoryEntrenamiento extends IDAOEntrenamiento {
    private DataMemory context;
    public DAOMemoryEntrenamiento() {
        this.context =DataMemory.getInstance();
    }

    @Override
    public Entrenamiento getById(String id) {
        return null;
    }

    @Override
    public List<Entrenamiento> getAll() {
        return null;
    }

    @Override
    public boolean update(Entrenamiento model) {
        return false;
    }

    @Override
    public boolean delete(Entrenamiento model) {
        return false;
    }

    @Override
    public boolean add(Entrenamiento model) {
        return false;
    }
}
