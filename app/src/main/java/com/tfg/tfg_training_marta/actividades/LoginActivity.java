package com.tfg.tfg_training_marta.actividades;

import android.content.Context;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;


import com.tfg.tfg_training_marta.R;
import com.tfg.tfg_training_marta.fragments.login.LoginFragment;
import com.tfg.tfg_training_marta.fragments.login.SigninFragment;
import com.tfg.tfg_training_marta.managers.DisplayFragmentManager;

import java.util.ArrayList;
import java.util.List;

public class LoginActivity extends AppCompatActivity {


    private FragmentManager _fragmentManager;
    private List<Fragment> _fragments = new ArrayList<>();
    private DisplayFragmentManager _displayFragmentManager;

    private Fragment _currentFragment;

    private Context _context;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_login);


        //setSupportActionBar(binding.toolbar);

        _context = this;

        _fragments.add(new LoginFragment());
        _fragments.add(new SigninFragment());
        _currentFragment = _fragments.get(0);

        _displayFragmentManager = new DisplayFragmentManager(getSupportFragmentManager());
        _displayFragmentManager.displayFragment(_currentFragment, R.id.content_frame_login_activity);



    }

    @Override
    public void onBackPressed() {
        if (_currentFragment instanceof SigninFragment) {
            // Mostrar el fragmento de inicio de sesión (login)
            _displayFragmentManager.displayFragment(new LoginFragment(), R.id.content_frame_login_activity);
            _currentFragment = new LoginFragment();
        } else {
            super.onBackPressed();
        }
    }
}