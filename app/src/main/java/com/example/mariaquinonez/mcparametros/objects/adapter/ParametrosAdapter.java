

package com.example.mariaquinonez.mcparametros.objects.adapter;

import android.app.Activity;
import android.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.mariaquinonez.mcparametros.R;
import com.example.mariaquinonez.mcparametros.objects.Parametros;



import java.util.List;

public class ParametrosAdapter extends ArrayAdapter<Parametros> {

    private List<Parametros> mParametros;
    private Activity activity;
    private int resourceLayout;


    public ParametrosAdapter(List<Parametros> mParametros, Activity activity, int resourceLayout) {
        super(activity, resourceLayout, mParametros);
        this.mParametros = mParametros;
        this.activity = activity;
        this.resourceLayout = resourceLayout;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Get the data item for this position
        Parametros parametros = getItem(position);
        // Check if an existing view is being reused, otherwise inflate the view
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(resourceLayout, parent, false);
        }

        // Lookup view for data population
        TextView tvcodParametro = (TextView) convertView.findViewById(R.id.tv_cod);
        TextView tvNoCia = (TextView) convertView.findViewById(R.id.tv_noCia);
        TextView tvDato= (TextView) convertView.findViewById(R.id.tv_dato);
        TextView tvNombre=(TextView) convertView.findViewById(R.id.tv_nombre);
        // Populate the data into the template view using the data object
        tvcodParametro.setText(parametros.getCodParametro());
        tvNoCia.setText(parametros.getNoCia());
        tvDato.setText(parametros.getDato());
        tvNombre.setText(parametros.getNombre());
        // Return the completed view to render on screen
        return convertView;
    }


}