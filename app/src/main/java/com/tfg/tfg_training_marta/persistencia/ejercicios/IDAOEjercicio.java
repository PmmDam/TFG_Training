package com.tfg.tfg_training_marta.persistencia.ejercicios;

import com.tfg.tfg_training_marta.persistencia.contexto.AppConfig;
import com.tfg.tfg_training_marta.persistencia.contexto.ModoPersistencia;

public abstract class IDAOEjercicio {
    public static IDAOEjercicio getInstance()
    {
        if (AppConfig.Modo == ModoPersistencia.MEMORIA)
        {
            return new DAOMemoryEjercicio();
        }
        if (AppConfig.Modo == ModoPersistencia.FIREBASE)
        {
            return new DAOFirebaseEjercicio();
        }
        return null;
    }

}
