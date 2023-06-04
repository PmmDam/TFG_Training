package com.tfg.tfg_training_marta.adaptadores;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.tfg.tfg_training_marta.R;
import com.tfg.tfg_training_marta.modelos.LineaUsuario;
import com.tfg.tfg_training_marta.persistencia.lineaEntrenamiento.IDAOLineaUsuario;

import java.util.List;

public class LineaUsuarioListViewAdapter extends BaseAdapter {

    IDAOLineaUsuario idaoEntrenamiento = IDAOLineaUsuario.getInstance();
    private Context _context;
    private final List<LineaUsuario> _items;
    public LineaUsuarioListViewAdapter(@NonNull Context context, @NonNull List<LineaUsuario> items) {
        //super(context, R.layout.adapter_listview_facturas, items);
        _items = items;
        _context = context;
    }
    //El método getCount devuelve el número de elementos en la lista.
    @Override
    public int getCount() {
        return _items.size();
    }

    //El método getItem devuelve el elemento en la posición especificada.
    @Override
    public Object getItem(int position) {
        LineaUsuario entrenamiento = _items.get(position);
        return entrenamiento;
    }

    //El método getItemId devuelve la posición del elemento.
    @Override
    public long getItemId(int position) {
        return position;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        //En getView, primero se verifica si convertView es nula.
        //  Si es nula, se inflama el layout personalizado usando un LayoutInflater y se asigna a convertView.
        //  Si no es nula, se usa directamente.
        if (convertView == null) {
            LayoutInflater inflater = LayoutInflater.from(_context);
            convertView = inflater.inflate(R.layout.adapter_listview_linea_entrenamiento, parent, false);
        }
        LineaUsuario lineaUsuario = _items.get(position);
        //Luego, se obtiene una referencia a un TextView dentro del layout personalizado.
        TextView itemNumberLbl = convertView.findViewById(R.id.entrenamiento_listview_item_number);
        TextView nombreLbl = convertView.findViewById(R.id.entrenamiento_listview_nombre);
        TextView fechaLbl = convertView.findViewById(R.id.entrenamiento_listview_fecha);
        CheckBox cbCompletado = convertView.findViewById(R.id.entrenamiento_listview_checkbox);

        //Finalmente, se establece el texto del TextView con el elemento correspondiente de la lista
        itemNumberLbl.setText(String.valueOf(position));
        nombreLbl.setText(String.valueOf(lineaUsuario.getNombreEntrenamiento()));
        fechaLbl.setText(String.valueOf(lineaUsuario.getFechaInicio().toDate()));
        cbCompletado.setActivated(lineaUsuario.isCompletado());

        //y se devuelve la View resultante
        return convertView;
    }
}