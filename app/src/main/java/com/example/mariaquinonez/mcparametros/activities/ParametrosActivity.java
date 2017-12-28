package com.example.mariaquinonez.mcparametros.activities;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.mariaquinonez.mcparametros.R;
import com.example.mariaquinonez.mcparametros.helpers.CustomDialogs;
import com.example.mariaquinonez.mcparametros.helpers.ObjectTreatment;
import com.example.mariaquinonez.mcparametros.objects.Login;
import com.example.mariaquinonez.mcparametros.objects.Parametros;
import com.example.mariaquinonez.mcparametros.objects.ParametrosParcelable;
import com.example.mariaquinonez.mcparametros.objects.adapter.ParametrosAdapter;
import com.example.mariaquinonez.mcparametros.objects.ws.ServerResponse;
import com.example.mariaquinonez.mcparametros.objects.ws.response.GetParametrosResponse;
import com.example.mariaquinonez.mcparametros.ws.clients.ParametroClient;

import java.util.ArrayList;
import java.util.List;

public class ParametrosActivity extends AppCompatActivity implements com.example.mariaquinonez.mcparametros.helpers.interfaces.DialogInterface {
    private ProgressDialog progressDialog;
    ServerResponse serverResponse;

    private ListView lvParams;
    private List<Parametros> listParametros = new ArrayList<>();
    ParametrosAdapter adapter;
    private GetParametrosResponse getParametrosResponse;
    public static final String key = "llave";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_params);
        listParametros = new ArrayList<>();
        lvParams = findViewById(R.id.lv_params);

        progressDialog = ProgressDialog.show(ParametrosActivity.this, "", "procesando solicitud");
        String json = "{\"webservice\":\"Parametros\",\"no_cia\":\"40\"}";
        ParametroClient parametroClient = new ParametroClient(ParametrosActivity.this, ParametrosActivity.this, json);
        parametroClient.execute();


        lvParams.setClickable(true);
        lvParams.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(ParametrosActivity.this, EditParametersActivity.class);


                Parametros parametros = new Parametros();
                parametros = (Parametros) lvParams.getAdapter().getItem(i);
                Log.d("Data@@@@", parametros.getDato());

                ParametrosParcelable parcelable = new ParametrosParcelable();
                parcelable.setParametros(parametros);
                intent.putExtra("llave", parcelable);
                startActivity(intent);

            }
        });

    }

    @Override
    public void ejectAction() {

    }

    @Override
    public void processAction(ServerResponse serverResponse) {

        progressDialog.cancel();

        if (serverResponse.isSuccessful()) {

            getParametrosResponse = ObjectTreatment.parseStrToObject(serverResponse.getJson(), GetParametrosResponse.class);

            if (getParametrosResponse.isSuccessful()) {
                for (Parametros params : getParametrosResponse.getParametrosList()) {

                    Log.d("parametrosRespuesta@", params.getCodParametro());
                    Log.d("parametrosRespuesta@", params.getDato());
                }
                listParametros = getParametrosResponse.getParametrosList();
                adapter = new ParametrosAdapter(listParametros, this, R.layout.item_line_parametros);
                lvParams.setAdapter(adapter);
                lvParams.setClickable(true);


            } else {
                CustomDialogs.showOk(null, getParametrosResponse.getMessage(), "Aceptar", this);
            }

        } else {
            CustomDialogs.showOk(null, serverResponse.getMessage(), "Aceptar", this);
        }
    }
}
