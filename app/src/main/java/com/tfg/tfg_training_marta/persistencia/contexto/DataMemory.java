package com.tfg.tfg_training_marta.persistencia.contexto;

import com.google.firebase.Timestamp;
import com.tfg.tfg_training_marta.modelos.Ejercicio;
import com.tfg.tfg_training_marta.modelos.Entrenamiento;
import com.tfg.tfg_training_marta.modelos.Idioma;
import com.tfg.tfg_training_marta.modelos.Imagen;
import com.tfg.tfg_training_marta.modelos.LineaUsuario;
import com.tfg.tfg_training_marta.modelos.Usuario;
import com.tfg.tfg_training_marta.modelos.enumeraciones.Genero;
import com.tfg.tfg_training_marta.modelos.enumeraciones.TipoEntrenamiento;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


//Esta clase provee el contexto en memoria simulando una sesion con la base de datos.
public class DataMemory {

    //Patrón Singleton
    private static DataMemory instance;

    public static DataMemory getInstance(){
        if(instance == null){
            instance = new DataMemory();
        }
        return instance;
    }

    //Propiedades
    public List<Ejercicio> Ejercicios = new ArrayList<>();
    public List<Usuario> Usuarios = new ArrayList<>();
    public List<Entrenamiento> Entrenamientos = new ArrayList<>();
    public List<Imagen> Imagenes = new ArrayList<>();
    public List<LineaUsuario> LineasUsuario = new ArrayList<>();
    public List<Idioma> Idiomas = new ArrayList<>();

    //Constructor
    public DataMemory() {
        InitializeEjercicios();
        InitializeEntrenamientos();
        InitializeImagenes();
        InitializeUsuarios();
        InitializeLineaUsuari0();
        InitializeIdioma();
    }


    private void InitializeEjercicios(){
        Ejercicios.add(new Ejercicio("1", "Sentadillas", 10, 30, 4, new ArrayList<String>(Arrays.asList("1","2"))));
        Ejercicios.add(new Ejercicio("2", "Zancada", 6, 45, 3, new ArrayList<String>(Arrays.asList("3","4"))));
    }

    private void InitializeEntrenamientos(){
        Entrenamientos.add(new Entrenamiento("1", "Torso/Pierna", "https://www.youtube.com/", "https://www.pdf.com/", new ArrayList<String>(Arrays.asList("1","2"))));
    }

    private void InitializeImagenes(){
        Imagenes.add(new Imagen("1", "Sentadillas_1", "Rutainventada.png"));
    }


    private void InitializeUsuarios(){
        Usuarios.add(new Usuario("1", "marta@gmail.com", Genero.MUJER, "prueba01", "Marta","Riaño", "654987321"));
    }

    private void InitializeLineaUsuari0(){
        LineasUsuario.add(new LineaUsuario("1", "1","Torso/Pierna", 45, Timestamp.now(), true, TipoEntrenamiento.OBLIGATORIO));
        LineasUsuario.add(new LineaUsuario("2", "1","Tabata", 30, Timestamp.now(), false, TipoEntrenamiento.OPTATIVO));
    }
    private void InitializeIdioma(){
        Idiomas.add(new Idioma("1", "es", "Español/(España)"));
        Idiomas.add(new Idioma("2", "en", "English"));
        Idiomas.add(new Idioma("3", "de", "Deutsche"));
        Idiomas.add(new Idioma("4", "fr", "Français"));
    }

}
