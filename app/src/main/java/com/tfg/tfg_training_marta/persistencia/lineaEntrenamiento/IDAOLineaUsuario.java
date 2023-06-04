package com.tfg.tfg_training_marta.persistencia.lineaEntrenamiento;

import com.tfg.tfg_training_marta.modelos.Entrenamiento;
import com.tfg.tfg_training_marta.modelos.LineaUsuario;
import com.tfg.tfg_training_marta.persistencia.contexto.AppConfig;
import com.tfg.tfg_training_marta.persistencia.contexto.IDAOBase;
import com.tfg.tfg_training_marta.persistencia.contexto.ModoPersistencia;

import java.util.ArrayList;
import java.util.List;

public abstract class IDAOLineaUsuario implements IDAOBase<LineaUsuario> {

    public static IDAOLineaUsuario getInstance()
    {
        if (AppConfig.Modo == ModoPersistencia.MEMORIA)
        {
            return new DAOMemoryLineaUsuario();
        }
        if (AppConfig.Modo == ModoPersistencia.FIREBASE)
        {
            return new DAOFirebaseLineaUsuario();
        }
        return null;
    }

    public abstract List<LineaUsuario> getByUsuarioId(String userId );


}
