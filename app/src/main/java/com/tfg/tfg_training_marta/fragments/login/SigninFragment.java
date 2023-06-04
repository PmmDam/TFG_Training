package com.tfg.tfg_training_marta.fragments.login;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;


import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.FirebaseFirestore;
import com.tfg.tfg_training_marta.R;
import com.tfg.tfg_training_marta.managers.DisplayFragmentManager;
import com.tfg.tfg_training_marta.modelos.Usuario;
import com.tfg.tfg_training_marta.modelos.enumeraciones.Genero;
import com.tfg.tfg_training_marta.persistencia.usuarios.IDAOUsuario;


public class SigninFragment extends Fragment {


    private IDAOUsuario daoUsuario;
    private Context _context;
    private EditText _nombreUserEditText;
    private EditText _apellidoUserEditText;
    private EditText _tlfnUserEditText;
    private EditText _emailUserEditText;
    private EditText _passwordUserEditText;

    private Spinner _generoSpinner;
    private Button _submitBtn;
    private FirebaseAuth _mAuth = FirebaseAuth.getInstance();
    private FirebaseFirestore _db;
    private Usuario _usuario;
    private DisplayFragmentManager _displayFragmentManager;

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

        _context = getContext();
        _displayFragmentManager = new DisplayFragmentManager(getParentFragmentManager());
        _generoSpinner = (Spinner) view.findViewById(R.id.gender_spinner_signin_fragment);
        _generoSpinner.setAdapter(new ArrayAdapter<Genero>(getContext(), android.R.layout.simple_spinner_item, Genero.values()));

        _nombreUserEditText = view.findViewById(R.id.user_name_txt_signin_fragment);
        _apellidoUserEditText = view.findViewById(R.id.user_last_name_1_txt_signin_fragment);
        _tlfnUserEditText = view.findViewById(R.id.user_tlfn_txt_signin_fragment);
        _emailUserEditText = view.findViewById(R.id.user_email_txt_signin_fragment);
        _passwordUserEditText = view.findViewById(R.id.user_password_txt_signin_fragment);


        _submitBtn = view.findViewById(R.id.submit_btn_signin_fragment);
        _submitBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                _usuario= getUsuarioDelInput();
                if(_usuario != null){

                   registroUsuario(_usuario);
                    // createAccount(_usuario.getEmail(),_usuario.getPass());
                }
            }
        });

        return view;
    }

    private Usuario getUsuarioDelInput() {
        Usuario usuario = new Usuario();


        usuario.setNombre(_nombreUserEditText.getText().toString());
        usuario.setApellido(_apellidoUserEditText.getText().toString());

        if(_nombreUserEditText.getText().toString().isEmpty()){
            Toast.makeText(_context, "El email es obligatorio", Toast.LENGTH_SHORT).show();
            return null;
        }

        usuario.setEmail(_emailUserEditText.getText().toString());

        if(_passwordUserEditText.getText().toString().isEmpty()){
            Toast.makeText(_context, "El email es obligatorio", Toast.LENGTH_SHORT).show();
            return null;
        }

        usuario.setPass(_passwordUserEditText.getText().toString());

        usuario.setTlfn(_tlfnUserEditText.getText().toString());

        int generoSeleccionado = _generoSpinner.getSelectedItemPosition();
        usuario.setGenero((Genero) _generoSpinner.getItemAtPosition(generoSeleccionado));

        return usuario;
    }

    private void registroUsuario(Usuario usuario) {
        _mAuth.createUserWithEmailAndPassword(usuario.getEmail(), usuario.getPass())
                .addOnCompleteListener(getActivity(), new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {

                            //Si el usuario existe en la plataforma, no lo registramos
                            if(!task.getResult().getAdditionalUserInfo().isNewUser()){
                                Toast.makeText(_context, "El email está en uso", Toast.LENGTH_SHORT).show();
                                return;
                            }

                            // Sign in success, update UI with the signed-in user's information
                            FirebaseUser user = _mAuth.getCurrentUser();
                            _db = FirebaseFirestore.getInstance();
                            _db.collection("usuario").add(usuario);
                            Toast.makeText(_context, "¡Te has registrado correctamente!", Toast.LENGTH_SHORT).show();
                            _displayFragmentManager.displayFragment(new LoginFragment(), R.id.content_frame_login_activity);

                        } else {
                            Toast.makeText(_context, "Ha ocurrido un error, el registro no se ha realizado", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }
    private void createAccount(String email, String password) {


        _mAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(requireActivity(), new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            FirebaseUser user = _mAuth.getCurrentUser();
                            _db = FirebaseFirestore.getInstance();
                            _db.collection("usuario").add(_usuario);
                            Toast.makeText(_context, "¡Te has registrado correctamente!", Toast.LENGTH_SHORT).show();
                            //_displayFragmentManager.displayFragment(new LoginFragment(),getActivity().findViewById( R.id.content_frame_main_activity));
                            getParentFragmentManager().beginTransaction()
                                    .replace(R.id.content_frame_main_activity, new LoginFragment())
                                    .commit();
                        } else {
                            Toast.makeText(_context, "Ha ocurrido un error, el registro no se ha realizado", Toast.LENGTH_SHORT).show();
                        }


                    }
                });
    }
}