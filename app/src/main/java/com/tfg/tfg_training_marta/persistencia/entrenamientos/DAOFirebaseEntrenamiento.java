package com.tfg.tfg_training_marta.persistencia.entrenamientos;

import com.tfg.tfg_training_marta.modelos.Ejercicio;
import com.tfg.tfg_training_marta.modelos.Entrenamiento;

import java.util.ArrayList;
import java.util.List;

public class DAOFirebaseEntrenamiento extends  IDAOEntrenamiento{
    @Override
    public Entrenamiento getById(String id) {
        return null;
    }

    @Override
    public List<Entrenamiento> getAll() {
        return null;
    }

    @Override
    public boolean update(Entrenamiento model) {
        return false;
    }

    @Override
    public boolean delete(Entrenamiento model) {
        return false;
    }

    @Override
    public boolean add(Entrenamiento model) {
        return false;
    }

/*    @Override
    public List<Ejercicio> getAllEjerciciosByEntrenamientoId(String entrenamientoId) {
        List<Ejercicio> result = new ArrayList<>();

        Entrenamiento entrenamiento = getById(entrenamientoId);

        for (String idEjercicio:entrenamiento.getEjerciciosId()) {
            result.add(idaoEjercicio.getById(idEjercicio));
        }

        return result;
    }*/
    @Override
    public List<Entrenamiento> getEntrenamientosByUsuarioId(String userId) {
        return null;
    }

    @Override
    public List<Entrenamiento> getEntrenamientosDeHoyByUsuarioId(String userId) {
        return null;
    }
}
