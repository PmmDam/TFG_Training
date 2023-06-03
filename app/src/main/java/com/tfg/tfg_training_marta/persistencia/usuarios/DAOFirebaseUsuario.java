package com.tfg.tfg_training_marta.persistencia.usuarios;

import com.tfg.tfg_training_marta.modelos.Usuario;

import java.util.List;

public class DAOFirebaseUsuario extends IDAOUsuario{
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

    @Override
    public Usuario login(String email, String password) {
        return null;
    }
}
