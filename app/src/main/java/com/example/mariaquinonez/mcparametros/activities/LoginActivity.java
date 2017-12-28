package com.example.mariaquinonez.mcparametros.activities;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import com.example.mariaquinonez.mcparametros.R;
import com.example.mariaquinonez.mcparametros.helpers.CustomDialogs;
import com.example.mariaquinonez.mcparametros.helpers.ObjectTreatment;
import com.example.mariaquinonez.mcparametros.objects.Login;
import com.example.mariaquinonez.mcparametros.objects.ws.ServerResponse;
import com.example.mariaquinonez.mcparametros.objects.ws.response.GetLoginResponse;
import com.example.mariaquinonez.mcparametros.ws.clients.ParametroClient;


public class LoginActivity extends AppCompatActivity implements com.example.mariaquinonez.mcparametros.helpers.interfaces.DialogInterface {
    private EditText etPassword;
    private EditText etEmail;
    ServerResponse serverResponse;
    private Login login= new Login();
    private GetLoginResponse getLoginResponse;
    private ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

    }
    public void login(View view){
        etEmail= findViewById(R.id.ti_email);
        etPassword=findViewById(R.id.ti_pass);

        progressDialog= ProgressDialog.show(LoginActivity.this,"","Cargando...");
        String json="{\"webservice\": \"Login\"," +
                "\"usuario\":\"" +
                etEmail.getText().toString()+
                "\"" +
                ",\"clave\":\"" +
                etPassword.getText().toString() +
                "\"" +
                "}";

        ParametroClient parametroClient= new ParametroClient(LoginActivity.this,LoginActivity.this,json);
        parametroClient.execute();

    }

    @Override
    public void ejectAction() {

    }

    @Override
    public void processAction(ServerResponse serverResponse) {
        progressDialog.cancel();
        if(serverResponse.isSuccessful()){
            getLoginResponse= ObjectTreatment.parseStrToObject(serverResponse.getJson(),GetLoginResponse.class);
            if(getLoginResponse.isSuccessful()){
                Intent intent= new Intent(this, ParametrosActivity.class);
                startActivity(intent);
            }else{
                CustomDialogs.showOk(null, getLoginResponse.getMessage(),"Aceptar",this);
            }
        } else {
            CustomDialogs.showOk(null, serverResponse.getMessage(), "Aceptar", this);
        }
    }
}
