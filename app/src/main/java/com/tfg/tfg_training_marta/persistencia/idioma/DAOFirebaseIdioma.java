package com.tfg.tfg_training_marta.persistencia.idioma;

import androidx.annotation.NonNull;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;
import com.google.firebase.firestore.model.Document;
import com.tfg.tfg_training_marta.modelos.Idioma;

import java.util.ArrayList;
import java.util.List;

public class DAOFirebaseIdioma extends IDAOIdioma {

    FirebaseFirestore _db;
    CollectionReference coleccionIdioma;
    public DAOFirebaseIdioma() {
        _db = FirebaseFirestore.getInstance();
        coleccionIdioma = _db.collection("idiomas");
    }



    public Idioma getById(String id) {
        Idioma idioma = null;
        DocumentReference docRef = coleccionIdioma.document(id);
        docRef.get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                if (task.isSuccessful()) {
                    DocumentSnapshot document = task.getResult();
                    if (document.exists()) {
                        mapearDocumentoAIdioma(document,idioma);
                    }
                }
            }
        });
        return idioma;
    }

    @Override
    public List<Idioma> getAll() {
        List<Idioma> idiomas = new ArrayList<>();
        coleccionIdioma.get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
            @Override
            public void onComplete(@NonNull Task<QuerySnapshot> task) {
                if (task.isSuccessful()) {
                    for (QueryDocumentSnapshot document : task.getResult()) {
                        Idioma idioma = new Idioma();
                        mapearDocumentoAIdioma(document, idioma);

                        idiomas.add(idioma);
                    }
                } else {

                }
            }
        });

        return idiomas;
    }

    private void mapearDocumentoAIdioma(DocumentSnapshot document, Idioma idioma) {
        idioma.setCountryCode(document.getString("codigoPais"));
        idioma.setCountryCode(document.getString("codigoPais"));
        idioma.setDescription(document.getString("descripcion"));
    }

    @Override
    public boolean update(Idioma model) {
        return false;
    }

    @Override
    public boolean delete(Idioma model) {
        return false;
    }

    @Override
    public boolean add(Idioma model) {
        return false;
    }
}
