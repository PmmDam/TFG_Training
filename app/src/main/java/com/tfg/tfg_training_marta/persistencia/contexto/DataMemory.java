package com.tfg.tfg_training_marta.persistencia.contexto;

import com.google.firebase.Timestamp;
import com.tfg.tfg_training_marta.modelos.Ejercicio;
import com.tfg.tfg_training_marta.modelos.Entrenamiento;
import com.tfg.tfg_training_marta.modelos.Imagen;
import com.tfg.tfg_training_marta.modelos.LineaEntrenamiento;
import com.tfg.tfg_training_marta.modelos.Usuario;
import com.tfg.tfg_training_marta.modelos.enumeraciones.Genero;
import com.tfg.tfg_training_marta.modelos.enumeraciones.TipoEntrenamiento;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


//Esta clase provee el contexto en memoria simulando una sesion con la base de datos.
public class DataMemory {

    public List<Ejercicio> Ejercicios = new ArrayList<>();
    public List<Usuario> Usuarios = new ArrayList<>();
    public List<Entrenamiento> Entrenamientos = new ArrayList<>();
    public List<Imagen> Imagenes = new ArrayList<>();
    public List<LineaEntrenamiento> LineasEntrenamiento = new ArrayList<>();

    public DataMemory() {
        InitializeEjercicios();
        InitializeEntrenamientos();
        InitializeImagenes();
        InitializeUsuarios();
        InitializeLineasEntrenamientos();
    }

    private void InitializeEjercicios(){
        Ejercicios.add(new Ejercicio("asd1wefsd", "Sentadillas", 10, 30, 4, new ArrayList<String>(Arrays.asList("1","2"))));
        Ejercicios.add(new Ejercicio("fntghj", "Zancada", 6, 45, 3, new ArrayList<String>(Arrays.asList("3","4"))));
    }

    private void InitializeEntrenamientos(){
        Entrenamientos.add(new Entrenamiento("asdafgh", "Torso/Pierna", "https://www.youtube.com/", "https://www.pdf.com/", new ArrayList<String>(Arrays.asList("asd1wefsd","fntghj"))));
    }

    private void InitializeImagenes(){
        Imagenes.add(new Imagen("1", "Sentadillas_1", "Rutainventada.png"));
    }


    private void InitializeUsuarios(){
        Usuarios.add(new Usuario("5678yukg", "marta@gmail.com", Genero.MUJER, "prueba01", "Marta","Riaño", "654987321"));
    }

    private void InitializeLineasEntrenamientos(){
        LineasEntrenamiento.add(new LineaEntrenamiento("5678yukg", "asdafgh", 45, Timestamp.now(), true, TipoEntrenamiento.OBLIGATORIO));
    }

}
