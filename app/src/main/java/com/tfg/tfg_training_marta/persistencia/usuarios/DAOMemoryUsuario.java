package com.tfg.tfg_training_marta.persistencia.usuarios;

import com.google.android.gms.tasks.Task;
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

    @Override
    public Task<Usuario> getUserByEmail(String email) {
        return null;
    }


    /**
     * Devolverá nulo en caso de que el usuario no es haya encontrado
     * @param email
     * @param password
     * @return
     */

}
