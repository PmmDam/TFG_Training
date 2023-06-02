package com.tfg.tfg_training_marta.persistencia.imagenes;

import com.tfg.tfg_training_marta.modelos.Imagen;
import com.tfg.tfg_training_marta.persistencia.contexto.DataMemory;

import java.util.List;

public class DAOMemoryImagen extends IDAOImagen{

    private DataMemory context;
    public DAOMemoryImagen() {
        this.context =DataMemory.getInstance();
    }


    @Override
    public Imagen getById(String id) {
        return null;
    }

    @Override
    public List<Imagen> getAll() {
        return null;
    }

    @Override
    public boolean update(Imagen model) {
        return false;
    }

    @Override
    public boolean delete(Imagen model) {
        return false;
    }

    @Override
    public boolean add(Imagen model) {
        return false;
    }
}
