package com.tfg.tfg_training_marta.fragments.login;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;


import com.tfg.tfg_training_marta.R;
import com.tfg.tfg_training_marta.persistencia.usuarios.IDAOUsuario;


public class SigninFragment extends Fragment {


    private IDAOUsuario daoUsuario;
    private Context _context;

    public SigninFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
        }


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_signin, container, false);



        return  view;
    }
}