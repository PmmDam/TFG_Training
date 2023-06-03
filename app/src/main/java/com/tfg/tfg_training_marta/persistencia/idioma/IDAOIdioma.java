package com.tfg.tfg_training_marta.persistencia.idioma;

import com.tfg.tfg_training_marta.persistencia.contexto.AppConfig;
import com.tfg.tfg_training_marta.persistencia.contexto.IDAOBase;
import com.tfg.tfg_training_marta.persistencia.contexto.ModoPersistencia;
import com.tfg.tfg_training_marta.persistencia.entrenamientos.DAOFirebaseEntrenamiento;
import com.tfg.tfg_training_marta.persistencia.entrenamientos.DAOMemoryEntrenamiento;
import com.tfg.tfg_training_marta.persistencia.entrenamientos.IDAOEntrenamiento;

public abstract class IDAOIdioma implements IDAOBase {

    public static IDAOIdioma getInstance()
    {
        if (AppConfig.Modo == ModoPersistencia.MEMORIA)
        {
            return new DAOMemoryIdioma();
        }
        if (AppConfig.Modo == ModoPersistencia.FIREBASE)
        {
            return new DAOFirebaseIdioma();
        }
        return null;
    }
}
