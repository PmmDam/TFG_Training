package com.tfg.tfg_training_marta.fragments.main;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;

import com.tfg.tfg_training_marta.R;
import com.tfg.tfg_training_marta.adaptadores.LanguageListViewAdapter;
import com.tfg.tfg_training_marta.modelos.Idioma;
import com.tfg.tfg_training_marta.persistencia.idioma.IDAOIdioma;

import java.util.List;


public class IdiomaFragment extends Fragment {


    private View _view;
    private FragmentActivity _context;
    private ListView _listView;
    private LanguageListViewAdapter _adapter;

    public IdiomaFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        _view = inflater.inflate(R.layout.fragment_language, container, false);
        return _view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        _context = getActivity();
        _listView = (ListView) _view.findViewById(R.id.listView);
        //ArrayList<ModelIdioma> idiomas = _idaoIdioma.getAll();

        List<Idioma> languages = IDAOIdioma.getInstance().getAll();

        _adapter = new LanguageListViewAdapter(_context, languages);
        _listView.setAdapter(_adapter);

    }
}