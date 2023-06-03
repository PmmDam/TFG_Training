package com.tfg.tfg_training_marta.actividades;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.google.android.material.navigation.NavigationView;
import com.tfg.tfg_training_marta.R;
import com.tfg.tfg_training_marta.fragments.main.DashboardFragment;
import com.tfg.tfg_training_marta.fragments.main.EntrenamientoMaestroFragment;
import com.tfg.tfg_training_marta.fragments.main.HistoricoMaestroFragment;
import com.tfg.tfg_training_marta.fragments.main.IdiomaFragment;
import com.tfg.tfg_training_marta.managers.DisplayFragmentManager;
import com.tfg.tfg_training_marta.modelos.Usuario;
import com.tfg.tfg_training_marta.persistencia.usuarios.IDAOUsuario;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private View _headerLayout;
    private TextView _userLbl;
    private DrawerLayout _drawerLayout;
    private NavigationView _navView;
    private Toolbar _toolbar;
    private FragmentManager _fragmentManager;
    private List<Fragment> _fragments = new ArrayList<>();

    private Usuario _currentUser = null;
    private IDAOUsuario idaoUsuario;

    private DisplayFragmentManager _displayFragmentManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        //Asignamos el xml que contiene los componentes del layout principal
        setContentView(R.layout.activity_main);

        //Recuperamos la Toolbar del layout en función del ID que se le ha puesto en el xml
        _toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(_toolbar);

        //Inicializamos el FragmentManager y guardamos los distintos fragment a los que tenemos
        //intención de navegar en la lista
        _fragmentManager = getSupportFragmentManager();

        _fragments.add(new DashboardFragment());

        _fragments.add(new EntrenamientoMaestroFragment());
        _fragments.add(new HistoricoMaestroFragment());
        _fragments.add(new IdiomaFragment());

        //Inicializamos la clase que gestiona la navegación entre fragments
        _displayFragmentManager = new DisplayFragmentManager(getSupportFragmentManager());

        //Desplegamos el primer fragment utilizando un método
        _displayFragmentManager.displayFragment(_fragments.get(0),R.id.content_frame_main_activity);

        idaoUsuario = IDAOUsuario.getInstance();

        //Obtenemos el usuario que se ha pasado como argumento(Bundle) desde el LoginActivity
        String userId =  (String) getIntent().getSerializableExtra("userId");

        //Recuperamos el usuario logueado
        _currentUser = idaoUsuario.getById(userId);

        //Obtenemos los layouts por su id
        _navView = (NavigationView) findViewById(R.id.nav_view);
        _navView.setNavigationItemSelectedListener(new NavView_OnNavigationItemSelectedListener());
        _headerLayout = _navView.getHeaderView(0);

        //Inicializamos los componentes de tipo Label con los datos del usuario que se ha logueado
        _userLbl = _headerLayout.findViewById(R.id.lblUser);
        _userLbl.setText("Bienvenido/a: " + _currentUser.getNombre());

        //Implementamos el Toggle del drawer layout, es decir, que salaga el botón en la esquina
        //superior izquierda
        _drawerLayout = findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this,
                _drawerLayout,
                _toolbar,
                R.string.navigation_drawer_open,
                R.string.navigation_drawer_close);
        _drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

    }

    //Clase privada que implementa una interfaz que nos facilita realizar acciones en función del campo seleccionado en el navView
    private class NavView_OnNavigationItemSelectedListener implements NavigationView.OnNavigationItemSelectedListener {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
            switch (menuItem.getItemId()) {
                case R.id.menu_dashboard:

                    getSupportActionBar().setTitle("Dashboard");
                    _displayFragmentManager.displayFragment(_fragments.get(0),R.id.content_frame_main_activity);
                    break;
                case R.id.menu_entrenamientos:
                    _displayFragmentManager.displayFragment(_fragments.get(1),R.id.content_frame_main_activity);
                    getSupportActionBar().setTitle("Entrenamientos");
                    break;
                case R.id.menu_historial:
                    _displayFragmentManager.displayFragment(_fragments.get(2),R.id.content_frame_main_activity);
                    getSupportActionBar().setTitle("Historial");
                    break;
                case R.id.menu_idioma:
                    _displayFragmentManager.displayFragment(_fragments.get(3),R.id.content_frame_main_activity);
                    getSupportActionBar().setTitle("Idioma");
                    break;
                case R.id.menu_salir:
                    android.os.Process.killProcess(android.os.Process.myPid());
                    System.exit(1);
                    break;
            }
            _drawerLayout.closeDrawers();
            return true;
        }
    }
}