package com.example.mariaquinonez.mcparametros.ws.clients;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

import com.example.mariaquinonez.mcparametros.helpers.interfaces.DialogInterface;
import com.example.mariaquinonez.mcparametros.objects.ws.ServerResponse;
import com.example.mariaquinonez.mcparametros.ws.ServletClient;

import java.io.UnsupportedEncodingException;

/**
 * Created by maria.quinonez on 19/12/2017.
 */

public class ParametroClient extends AsyncTask <Void,Void,ServerResponse>{

    private Context context;

    private DialogInterface dialogInterface;

    private String jSon;

    public ParametroClient(Context context, DialogInterface dialogInterface,String json) {
        this.context = context;
        this.dialogInterface = dialogInterface;
        this.jSon=json;
    }

    @Override
    protected ServerResponse doInBackground(Void...voids) {
        return ServletClient.connect(context,getEndPoint(jSon),null);
    }

    @Override
    protected void onPostExecute(ServerResponse serverResponse){
        dialogInterface.processAction(serverResponse);
    }

    public String getEndPoint(String jSon){
        String hashEncriptado="";

            Log.d("jsonNormal@",jSon);
            hashEncriptado=WsAppEncode.hashSHA256(jSon);

            String ENDPOINT="https://www.mcd.com.gt/WSapp/rest/gw/exec/?" +
                "noCia=40&" +
                "appId=7b52009b64fd0a2a49e6d8a939753077792b0554&" +
                "version=1.0.0&" +
                "jSonParam="+WsAppEncode.encoded(jSon)+"&" +
                "hash="+hashEncriptado;
        Log.d("ENDPOINT@",ENDPOINT);
        Log.d("jSonEncriptado@",hashEncriptado);
        return ENDPOINT;
    }

}
