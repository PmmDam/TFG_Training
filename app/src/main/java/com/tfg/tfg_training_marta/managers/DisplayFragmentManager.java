package com.tfg.tfg_training_marta.managers;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import java.util.List;


/***
 * Clase que se encarga de orquestar la navegación entre fragments
 */
public class DisplayFragmentManager {

    private FragmentManager _fragmentManager;

    public DisplayFragmentManager(FragmentManager fragmentManager) {
        _fragmentManager = fragmentManager;
    }


    public void displayFragment(List<Fragment> fragments ,int position,int contentFrameId) {

        //Obtenemos el fragment de la lista en función de la posición
        Fragment fragment = fragments.get(position);

        //Para gestionar la transacción entre fragments necesitamos crear una instancia de la clase
        //FragmentTransacion en función del fragmentManager
        FragmentTransaction transaction = _fragmentManager.beginTransaction();

        //Sustituye el fragment del el container especificado como parámetro por otro fragment que también se le
        //pasa como parámetro
        transaction.replace(contentFrameId, fragment);

        //Confirmamos los cambios y se ejecuta la transacción
        transaction.commit();

    }

    public void displayFragment(Fragment fragment,int contentFrameId) {

        //Para gestionar la transacción entre fragments necesitamos crear una instancia de la clase
        //FragmentTransacion en función del fragmentManager
        FragmentTransaction transaction = _fragmentManager.beginTransaction();

        //Sustituye el fragment del el container especificado como parámetro por otro fragment que también se le
        //pasa como parámetro
        transaction.replace(contentFrameId, fragment);

        //Confirmamos los cambios y se ejecuta la transacción
        transaction.commit();

    }
    public void goBack() {
        _fragmentManager.popBackStack();
    }
}
