package com.tfg.tfg_training_marta.persistencia.usuarios;

import android.content.Intent;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.FirebaseFirestore;
import com.tfg.tfg_training_marta.modelos.Usuario;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;

public class DAOFirebaseUsuario extends IDAOUsuario {

    private FirebaseAuth _mAuth;
    private FirebaseFirestore db;

    public DAOFirebaseUsuario() {
        _mAuth = FirebaseAuth.getInstance();
        db = FirebaseFirestore.getInstance();
    }

    @Override
    public Usuario getById(String id) {
        return null;
    }

    @Override
    public List<Usuario> getAll() {
        return null;
    }

    @Override
    public boolean update(Usuario model) {
        return false;
    }

    @Override
    public boolean delete(Usuario model) {
        return false;
    }

    @Override
    public boolean add(Usuario model) {
        return false;
    }

    @Override
    public Usuario login(String email, String password) {

        _mAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()) {


                } else {

                }
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {

            }
        });
        return null;
    }

    @Override
    public boolean signin(Usuario usuario) {
        _mAuth.createUserWithEmailAndPassword(usuario.getEmail(), usuario.getPass()).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                String id = _mAuth.getCurrentUser().getUid();
                Map<String, Object> map = new HashMap<>();
                map.put("id", id);
                map.put("name", usuario.getNombre());
                map.put("last_name", usuario.getApellido());
                map.put("email", usuario.getEmail());
                map.put("password", usuario.getPass());
                map.put("genre", usuario.getGenero());
                map.put("phone_number", usuario.getTlfn());


                db.collection("usuario").document(id).set(map).addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void unused) {

                    }
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {

                    }
                });
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {

            }
        });
        return  false;
    }
}
