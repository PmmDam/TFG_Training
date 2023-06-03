package com.tfg.tfg_training_marta.persistencia.entrenamientos;

import com.tfg.tfg_training_marta.modelos.Ejercicio;
import com.tfg.tfg_training_marta.modelos.Entrenamiento;
import com.tfg.tfg_training_marta.persistencia.contexto.AppConfig;
import com.tfg.tfg_training_marta.persistencia.contexto.IDAOBase;
import com.tfg.tfg_training_marta.persistencia.contexto.ModoPersistencia;
import com.tfg.tfg_training_marta.persistencia.ejercicios.DAOFirebaseEjercicio;
import com.tfg.tfg_training_marta.persistencia.ejercicios.DAOMemoryEjercicio;
import com.tfg.tfg_training_marta.persistencia.ejercicios.IDAOEjercicio;

import java.util.List;

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
    /***
     * Devuelve una lista de las instancias de los ejercicios que están asignados a un entrenamiento.
     * Esto hay que hacerlo así ya que el entrenamiento solo guarda los ids de los ejercicios.
     * @param entrenamientoId
     * @return
     */
    public abstract List <Ejercicio> getAllEjerciciosByEntrenamientoId(String entrenamientoId);

}
