package com.tfg.tfg_training_marta.fragments.login;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import androidx.fragment.app.Fragment;


import com.tfg.tfg_training_marta.R;
import com.tfg.tfg_training_marta.modelos.enumeraciones.Genero;
import com.tfg.tfg_training_marta.persistencia.usuarios.IDAOUsuario;


public class SigninFragment extends Fragment {


    private IDAOUsuario daoUsuario;
    private Context _context;
    private Spinner _generoSpinner = null;
    private Button _submitBtn = null;


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
        View view = inflater.inflate(R.layout.fragment_signin, container, false);

        _generoSpinner = (Spinner) view.findViewById(R.id.gender_spinner_signin_fragment);
        _generoSpinner.setAdapter(new ArrayAdapter<Genero>(getContext(), android.R.layout.simple_spinner_item, Genero.values()));

        _submitBtn = view.findViewById(R.id.submit_btn_signin_fragment);
        //Implementar el on click listener

        return view;
    }


}