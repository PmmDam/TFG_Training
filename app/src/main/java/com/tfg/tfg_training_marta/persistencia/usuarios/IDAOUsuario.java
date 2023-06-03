package com.tfg.tfg_training_marta.persistencia.usuarios;

import com.tfg.tfg_training_marta.modelos.Usuario;
import com.tfg.tfg_training_marta.persistencia.contexto.AppConfig;
import com.tfg.tfg_training_marta.persistencia.contexto.IDAOBase;
import com.tfg.tfg_training_marta.persistencia.contexto.ModoPersistencia;
import com.tfg.tfg_training_marta.persistencia.imagenes.DAOFirebaseImagen;
import com.tfg.tfg_training_marta.persistencia.imagenes.DAOMemoryImagen;
import com.tfg.tfg_training_marta.persistencia.imagenes.IDAOImagen;

public abstract class IDAOUsuario implements IDAOBase<Usuario> {

    public static IDAOUsuario getInstance()
    {
        if (AppConfig.Modo == ModoPersistencia.MEMORIA)
        {
            return new DAOMemoryUsuario();
        }
        if (AppConfig.Modo == ModoPersistencia.FIREBASE)
        {
            return new DAOFirebaseUsuario();
        }
        return null;
    }

    /**
     * Login del usuario
     * @param email
     * @param password
     * @return
     */
    public abstract Usuario login(String email,String password);
}
