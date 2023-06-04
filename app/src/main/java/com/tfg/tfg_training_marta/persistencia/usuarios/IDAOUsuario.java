package com.tfg.tfg_training_marta.persistencia.usuarios;

import com.google.android.gms.tasks.Task;
import com.tfg.tfg_training_marta.modelos.Usuario;
import com.tfg.tfg_training_marta.persistencia.contexto.AppConfig;
import com.tfg.tfg_training_marta.persistencia.contexto.IDAOBase;
import com.tfg.tfg_training_marta.persistencia.contexto.ModoPersistencia;

public abstract class IDAOUsuario implements IDAOBase<Usuario>{

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
    public abstract Task<Usuario> getUserByEmail(String email);
}

