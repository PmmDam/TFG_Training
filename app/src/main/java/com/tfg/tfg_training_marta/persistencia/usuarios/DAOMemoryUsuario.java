package com.tfg.tfg_training_marta.persistencia.usuarios;

import com.tfg.tfg_training_marta.modelos.Imagen;
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
        Usuario result = null;
        for (Usuario usuario : context.Usuarios) {
            if (usuario.getId().equals(id)) {
                result = usuario;
            }
        }
        return result;
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

    /**
     * Devolverá nulo en caso de que el usuario no es haya encontrado
     * @param email
     * @param password
     * @return
     */
    @Override
    public Usuario login(String email, String password) {
        Usuario selectedUser = null;

        for (Usuario user : context.Usuarios) {
            if(user.getEmail().equals(email) || user.getEmail().equals(email)){
                if(user.getPass().equals(password)){
                    selectedUser = user;
                }
            }
        }
        return selectedUser;
    }

    @Override
    public boolean signin(Usuario usuario) {
        return false;
    }
}
