package com.tfg.tfg_training_marta.fragments.main;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.tfg.tfg_training_marta.R;
import com.tfg.tfg_training_marta.modelos.Usuario;
import com.tfg.tfg_training_marta.persistencia.usuarios.IDAOUsuario;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link DashboardFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class DashboardFragment extends Fragment {


    private Usuario _usuario;
    private IDAOUsuario daoUsuario = IDAOUsuario.getInstance();

    private TextView _bienvenidaLbl = null;
    private TextView _nombreEntranamientoHoyLbl = null;

    public DashboardFragment() {
        // Required empty public constructor
    }

    public static DashboardFragment newInstance(String param1, String param2) {
        DashboardFragment fragment = new DashboardFragment();
        Bundle args = new Bundle();

        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle args = getArguments();

        if (args != null) {
            String userId = args.getString("userId");
            _usuario = daoUsuario.getById(userId);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_dashboard, container, false);

        _bienvenidaLbl = view.findViewById(R.id.bienvenida_dashboard_fragment);
        _nombreEntranamientoHoyLbl = view.findViewById(R.id.entrenamiento_hoy_dashboard_fragment);


        return view;
    }
}