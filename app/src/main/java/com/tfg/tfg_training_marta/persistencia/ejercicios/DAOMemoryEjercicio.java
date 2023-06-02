package com.tfg.tfg_training_marta.persistencia.ejercicios;

import com.tfg.tfg_training_marta.modelos.Ejercicio;
import com.tfg.tfg_training_marta.persistencia.contexto.DataMemory;

import java.util.List;

public class DAOMemoryEjercicio extends IDAOEjercicio {

    private DataMemory context;

    public DAOMemoryEjercicio() {
        this.context = DataMemory.getInstance();
    }

    @Override
    public Ejercicio getById(String id) {
        Ejercicio result = null;

        for (Ejercicio ejercicio : context.Ejercicios) {
            if (ejercicio.getId().equals(id)) {
                result = ejercicio;
            }
        }
        return result;
    }

    @Override
    public List<Ejercicio> getAll() {
        return context.Ejercicios;
    }

    @Override
    public boolean update(Ejercicio model) {

        for (Ejercicio ejercicio : context.Ejercicios) {
            if (ejercicio.getId().equals(model.getId())) {

                //Seteamos todas las propiedades del objeto persistente
                ejercicio.setTitulo(model.getTitulo());
                ejercicio.setSeries(model.getSeries());
                ejercicio.setRepeticiones(model.getRepeticiones());
                ejercicio.setImagenesId(model.getImagenesId());
                ejercicio.setDuracion(model.getDuracion());
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean delete(Ejercicio model) {
        return context.Ejercicios.remove(model);
    }

    @Override
    public boolean add(Ejercicio model) {
        return context.Ejercicios.add(model);
    }
}
