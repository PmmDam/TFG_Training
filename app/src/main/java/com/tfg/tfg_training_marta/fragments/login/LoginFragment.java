package com.tfg.tfg_training_marta.fragments.login;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import com.tfg.tfg_training_marta.R;
import com.tfg.tfg_training_marta.actividades.MainActivity;
import com.tfg.tfg_training_marta.managers.DisplayFragmentManager;
import com.tfg.tfg_training_marta.modelos.Usuario;
import com.tfg.tfg_training_marta.persistencia.usuarios.IDAOUsuario;


public class LoginFragment extends Fragment {


    private IDAOUsuario daoUsuario;

    private DisplayFragmentManager _displayFragmentManager;
    private Context _context;
    private EditText _userNameTxt;
    private EditText _passTxt;
    private Button _loginBtn;
    private Button _signingBtn;


    public LoginFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_login, container, false);

        _context = getContext();
        daoUsuario = IDAOUsuario.getInstance();
        _displayFragmentManager = new DisplayFragmentManager(getParentFragmentManager());

        _userNameTxt = view.findViewById(R.id.username_txt_login_fragment);
        _passTxt = view.findViewById(R.id.password_txt_login_fragment);
        _loginBtn = view.findViewById(R.id.login_btn_login_fragment);
        _signingBtn =view.findViewById(R.id.signin_btn_login_fragment);

        //Para debugguear más rápido
        _userNameTxt.setText("marta@gmail.com");
        _passTxt.setText("prueba01");

        _loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Obtenemos el input del usuario de los EditText correspondientes
                String userLogin = _userNameTxt.getText().toString();
                String password = _passTxt.getText().toString();

                //Intentamos hacer el login
                Usuario user = daoUsuario.login(userLogin,password);

                //Si el usuario ha podido loguearse devolverá un usuario, en caso contrario devuelve null
                if(user != null){

                    //Creamos una intención para navegar al MainActivity pasandole el contexto actual de la aplicación
                    Intent mainIntent = new Intent(_context, MainActivity.class);

                    //Añadimos el usuario al intent para poder acceder a el desde la otra actividad
                    mainIntent.putExtra("userId",user.getId());

                    //Iniciamos la navegación
                    startActivity(mainIntent);
                }else{
                    //Logueamos dentro de la aplicación para darle feedback al usuario
                    Toast.makeText(_context, "Login o contraseña incorrecta", Toast.LENGTH_SHORT).show();
                }
            }
        });


        //Listener para navegar al al fragment de registro si se clicka en el botón "Registrar"
        _signingBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                // Mostrar el fragmento de signin al hacer clic en el botón "Registrar"
                _displayFragmentManager.displayFragment(new SigninFragment(), R.id.content_frame_login_activity);
            }
        });

        return view;
    }
}