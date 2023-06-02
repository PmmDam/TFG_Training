package com.tfg.tfg_training_marta.persistencia.imagenes;

import com.tfg.tfg_training_marta.modelos.Imagen;
import com.tfg.tfg_training_marta.persistencia.contexto.AppConfig;
import com.tfg.tfg_training_marta.persistencia.contexto.IDAOBase;
import com.tfg.tfg_training_marta.persistencia.contexto.ModoPersistencia;
import com.tfg.tfg_training_marta.persistencia.entrenamientos.IDAOEntrenamiento;

public abstract class IDAOImagen implements IDAOBase<Imagen> {
    public static IDAOImagen getInstance()
    {
        if (AppConfig.Modo == ModoPersistencia.MEMORIA)
        {
            return new DAOMemoryImagen();
        }
        if (AppConfig.Modo == ModoPersistencia.FIREBASE)
        {
            return new DAOFirebaseImagen();
        }
        return null;
    }
}
