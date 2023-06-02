package com.tfg.tfg_training_marta.persistencia.imagenes;

import com.tfg.tfg_training_marta.modelos.Imagen;

import java.util.List;

public class DAOMemoryImagen extends IDAOImagen{
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
