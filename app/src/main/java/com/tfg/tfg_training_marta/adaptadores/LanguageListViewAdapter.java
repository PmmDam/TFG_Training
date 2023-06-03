package com.tfg.tfg_training_marta.adaptadores;

import android.content.Context;
import android.content.res.Configuration;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.tfg.tfg_training_marta.R;
import com.tfg.tfg_training_marta.actividades.MainActivity;
import com.tfg.tfg_training_marta.modelos.Idioma;
import com.tfg.tfg_training_marta.persistencia.contexto.AppConfig;

import java.util.List;
import java.util.Locale;

public class LanguageListViewAdapter extends BaseAdapter{
    private Context _context;
    private final List<Idioma> _items;

    public LanguageListViewAdapter(@NonNull Context context, @NonNull List<Idioma> items) {
        _items = items;
        _context = context;
    }

    @Override
    public int getCount() {
        return _items.size();
    }

    @Override
    public Object getItem(int position) {
        Idioma idioma = _items.get(position);
        return idioma;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    //Este método recupera los componentes de la interfaz de usuario, los inicializa y cambia el
    //idioma de la aplicacion en funcion del elemento seleccionado
    @Override
    public View getView(int position, View view, ViewGroup parent) {

        if (view == null) {
            LayoutInflater inflater = LayoutInflater.from(_context);
            view = inflater.inflate(R.layout.adapter_listview_language, parent, false);
        }
        Idioma idioma = _items.get(position);
        view.setTag(idioma);

        TextView lblText = view.findViewById(R.id.lblText);
        lblText.setText(idioma.getDescription());

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Idioma language = ((Idioma)view.getTag());
                AppConfig.IDIOMA_ACTUAL = language.getCountryCode();

                MainActivity mainActivity =(MainActivity)_context;

                //SharedPreferences settings = PreferenceManager.getDefaultSharedPreferences(mainActivity);
                Configuration config = mainActivity.getBaseContext().getResources().getConfiguration();
                if (!"".equals(AppConfig.IDIOMA_ACTUAL) && !config.locale.getLanguage().equals(AppConfig.IDIOMA_ACTUAL)) {
                    Locale locale = new Locale(AppConfig.IDIOMA_ACTUAL);
                    Locale.setDefault(locale);
                    config.locale = locale;
                    mainActivity.getBaseContext().getResources().updateConfiguration(config, mainActivity.getBaseContext().getResources().getDisplayMetrics());
                    mainActivity.recreate();
                    Log.d("CLICK: ", language.getDescription());
                }
                else{
                    Toast.makeText(mainActivity, "El lenguaje seleccionado ya está en uso", Toast.LENGTH_SHORT).show();
                }

            }
        });

        return view;
    }
}
