package com.tfg.tfg_training_marta.persistencia.entrenamientos;

import com.tfg.tfg_training_marta.modelos.Entrenamiento;
import com.tfg.tfg_training_marta.persistencia.contexto.AppConfig;
import com.tfg.tfg_training_marta.persistencia.contexto.IDAOBase;
import com.tfg.tfg_training_marta.persistencia.contexto.ModoPersistencia;
import com.tfg.tfg_training_marta.persistencia.ejercicios.DAOFirebaseEjercicio;
import com.tfg.tfg_training_marta.persistencia.ejercicios.DAOMemoryEjercicio;
import com.tfg.tfg_training_marta.persistencia.ejercicios.IDAOEjercicio;

public abstract class IDAOEntrenamiento implements IDAOBase<Entrenamiento> {
    public static IDAOEntrenamiento getInstance()
    {
        if (AppConfig.Modo == ModoPersistencia.MEMORIA)
        {
            return new DAOMemoryEntrenamiento();
        }
        if (AppConfig.Modo == ModoPersistencia.FIREBASE)
        {
            return new DAOFirebaseEntrenamiento();
        }
        return null;
    }
}
