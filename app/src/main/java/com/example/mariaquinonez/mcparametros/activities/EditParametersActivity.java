package com.example.mariaquinonez.mcparametros.activities;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.mariaquinonez.mcparametros.R;
import com.example.mariaquinonez.mcparametros.helpers.CustomDialogs;
import com.example.mariaquinonez.mcparametros.helpers.ObjectTreatment;
import com.example.mariaquinonez.mcparametros.helpers.interfaces.DialogInterface;
import com.example.mariaquinonez.mcparametros.objects.ParametrosParcelable;
import com.example.mariaquinonez.mcparametros.objects.ws.ServerResponse;
import com.example.mariaquinonez.mcparametros.objects.ws.response.GetActualizarResponse;
import com.example.mariaquinonez.mcparametros.objects.ws.response.GetLoginResponse;
import com.example.mariaquinonez.mcparametros.ws.clients.ParametroClient;

public class EditParametersActivity extends AppCompatActivity implements com.example.mariaquinonez.mcparametros.helpers.interfaces.DialogInterface {
    private EditText etCodigo;
    private EditText etNombre;
    private EditText etDato;
    private ProgressDialog progressDialog;
    private GetActualizarResponse getActualizarResponse;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_parameters);
        initComponents();
    }

    private void initComponents() {
        Bundle bundle = getIntent().getExtras();
        ParametrosParcelable parametrosParcelable = bundle.getParcelable("llave");
        Log.d("segundaActivity@@@@@@@", parametrosParcelable.getParametros().getDato());
        etCodigo = findViewById(R.id.txte_cod);
        etNombre = findViewById(R.id.txte_nombre);
        etDato = findViewById(R.id.txte_dato);

        etCodigo.setText(parametrosParcelable.getParametros().getCodParametro());
        etNombre.setText(parametrosParcelable.getParametros().getNombre());
        etDato.setText(parametrosParcelable.getParametros().getDato());

    }

    public void actualizar(View view) {
        progressDialog = ProgressDialog.show(EditParametersActivity.this, "", "Actualizando...");

        String json = "{\"webservice\": \"ActualizaParametro\"," +
                "\"no_cia\":\"40\"," +
                "\"cod_parametro\":" +
                etCodigo.getText().toString() +

                ",\"dato\":\"" +
                etDato.getText().toString() +
                "\"" +
                ",\"modifico\":\"user1\"}";
        Log.d("jsonActualizar:", json);
        ParametroClient parametroClient = new ParametroClient(EditParametersActivity.this, EditParametersActivity.this, json);
        parametroClient.execute();


    }

    @Override
    public void ejectAction() {

    }

    @Override
    public void processAction(ServerResponse serverResponse) {
        progressDialog.cancel();
        if (serverResponse.isSuccessful()) {
            getActualizarResponse = ObjectTreatment.parseStrToObject(serverResponse.getJson(), GetActualizarResponse.class);
            if (getActualizarResponse.isSuccessful()) {
                Toast toast = Toast.makeText(this, "Datos actualizados exitosamente", Toast.LENGTH_LONG + 3_000);
                toast.show();
                Intent intent = new Intent(this, ParametrosActivity.class);
                startActivity(intent);

            } else {
                CustomDialogs.showOk(null, getActualizarResponse.getMessage(), "Aceptar", this);
            }
        } else {
            CustomDialogs.showOk(null, serverResponse.getMessage(), "Aceptar", this);
        }
    }
}
