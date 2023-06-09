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
        return context.Entrenamientos;
    }

    @Override
    public boolean update(Entrenamiento model) {
        return false;
    }

    @Override
    public boolean delete(Entrenamiento model) {
        return context.Entrenamientos.remove(model);
    }

    @Override
    public boolean add(Entrenamiento model) {
        int maxId = 0;
        for (Entrenamiento entrenamiento: context.Entrenamientos) {
            int id = Integer.parseInt(entrenamiento.getId());
            if( maxId >= id){
                maxId =id;
            }

        }
        maxId++;
        model.setId(String.valueOf(maxId));
        return context.Entrenamientos.add(model);
    }



    @Override
    public List<Entrenamiento> getEntrenamientosByUsuarioId(String userId) {
        return null;
    }

    @Override
    public List<Entrenamiento> getEntrenamientosDeHoyByUsuarioId(String userId) {
        return null;
    }
}
