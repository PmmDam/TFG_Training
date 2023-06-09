package com.tfg.tfg_training_marta.persistencia.ejercicios;

import com.tfg.tfg_training_marta.modelos.Ejercicio;
import com.tfg.tfg_training_marta.persistencia.contexto.AppConfig;
import com.tfg.tfg_training_marta.persistencia.contexto.IDAOBase;
import com.tfg.tfg_training_marta.persistencia.contexto.ModoPersistencia;

public abstract class IDAOEjercicio implements IDAOBase<Ejercicio> {
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
