package com.tfg.tfg_training_marta.persistencia.entrenamientos;

import com.tfg.tfg_training_marta.modelos.Ejercicio;
import com.tfg.tfg_training_marta.modelos.Entrenamiento;
import com.tfg.tfg_training_marta.persistencia.contexto.DataMemory;
import com.tfg.tfg_training_marta.persistencia.ejercicios.IDAOEjercicio;

import java.util.ArrayList;
import java.util.List;

public class DAOMemoryEntrenamiento extends IDAOEntrenamiento {
    private DataMemory context;
    private IDAOEjercicio idaoEjercicio;

    public DAOMemoryEntrenamiento() {
        this.context = DataMemory.getInstance();
        this.idaoEjercicio = IDAOEjercicio.getInstance();
    }

    @Override
    public Entrenamiento getById(String id) {

        Entrenamiento result = null;
        for (Entrenamiento entrenamiento : context.Entrenamientos) {
            if (entrenamiento.getId().equals(id)) {
                result = entrenamiento;
            }
        }
        return result;
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



    @Override
    public List<Ejercicio> getAllEjerciciosByEntrenamientoId(String entrenamientoId) {
        List<Ejercicio> result = new ArrayList<>();

        Entrenamiento entrenamiento = getById(entrenamientoId);

        for (String idEjercicio:entrenamiento.getEjerciciosId()) {
            result.add(idaoEjercicio.getById(idEjercicio));
        }

        return result;
    }
}
