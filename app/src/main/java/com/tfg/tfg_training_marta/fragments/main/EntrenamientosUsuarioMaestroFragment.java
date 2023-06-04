package com.tfg.tfg_training_marta.fragments.main;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.tfg.tfg_training_marta.R;
import com.tfg.tfg_training_marta.adaptadores.LanguageListViewAdapter;
import com.tfg.tfg_training_marta.adaptadores.LineaUsuarioListViewAdapter;
import com.tfg.tfg_training_marta.modelos.LineaUsuario;
import com.tfg.tfg_training_marta.modelos.Usuario;
import com.tfg.tfg_training_marta.persistencia.idioma.IDAOIdioma;
import com.tfg.tfg_training_marta.persistencia.lineaEntrenamiento.IDAOLineaUsuario;
import com.tfg.tfg_training_marta.persistencia.usuarios.DAOFirebaseUsuario;
import com.tfg.tfg_training_marta.persistencia.usuarios.DAOMemoryUsuario;
import com.tfg.tfg_training_marta.persistencia.usuarios.IDAOUsuario;

import java.util.List;


public class EntrenamientosUsuarioMaestroFragment extends Fragment {


    private View _view;
    private FragmentActivity _context;
    private ListView _listView;
    private LineaUsuarioListViewAdapter _adapter;
    private int mColumnCount = 1;
    private Usuario _usuario = null;
    private IDAOUsuario daoUsuario = IDAOUsuario.getInstance();

    public EntrenamientosUsuarioMaestroFragment() {
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
        _view = inflater.inflate(R.layout.fragment_linea_usuario_list, container, false);
        return _view;

    }
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        _context = getActivity();
        _listView = (ListView) _view.findViewById(R.id.listview_linea_usuarios);


        List<LineaUsuario> lineaUsuarios = IDAOLineaUsuario.getInstance().getByUsuarioId(_usuario.getId());

        _adapter = new LineaUsuarioListViewAdapter(_context, lineaUsuarios);
        _listView.setAdapter(_adapter);

    }

}