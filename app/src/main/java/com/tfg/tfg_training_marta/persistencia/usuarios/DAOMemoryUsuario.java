package com.tfg.tfg_training_marta.persistencia.usuarios;

import com.tfg.tfg_training_marta.modelos.Usuario;
import com.tfg.tfg_training_marta.persistencia.contexto.DataMemory;

import java.util.List;

public class DAOMemoryUsuario extends IDAOUsuario{

    private DataMemory context;
    public DAOMemoryUsuario() {
        this.context =DataMemory.getInstance();
    }
    @Override
    public Usuario getById(String id) {
        return null;
    }

    @Override
    public List<Usuario> getAll() {
        return null;
    }

    @Override
    public boolean update(Usuario model) {
        return false;
    }

    @Override
    public boolean delete(Usuario model) {
        return false;
    }

    @Override
    public boolean add(Usuario model) {
        return false;
    }
}
