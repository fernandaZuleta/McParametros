package com.example.mariaquinonez.mcparametros.ws;

import android.content.Context;
import android.util.Log;

import com.example.mariaquinonez.mcparametros.R;
import com.example.mariaquinonez.mcparametros.helpers.ObjectTreatment;
import com.example.mariaquinonez.mcparametros.objects.ws.ServerResponse;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by maria.quinonez on 19/12/2017.
 */

public class ServletClient {
    private static final String STR_URL="http://54.174.33.86:7500/";

    public static ServerResponse connect (Context context,String endPoint, Object request){
        ServerResponse result= new ServerResponse();

        try {
            URL url= new URL (endPoint);
            HttpURLConnection connection= (HttpURLConnection) url.openConnection();
            connection.setConnectTimeout(30_000);
            connection.setReadTimeout(45_000);
            connection.setRequestMethod("POST");
            //connection.setRequestProperty("Host","www.mcd.com.gt");
            connection.setRequestProperty("Accept","application/json");
            connection.setRequestProperty("Content-Type","application/json");
            if(request!=null){
                BufferedOutputStream outputStream= new BufferedOutputStream(connection.getOutputStream());
                BufferedWriter writer= new BufferedWriter(new OutputStreamWriter(outputStream,"utf-8"));
                String jsonRequest= ObjectTreatment.parseObjectToStr(request);
                Log.d("ServerConnection", "jsonRequest: "+jsonRequest);
                writer.write(jsonRequest);
                writer.flush();
                writer.close();
                outputStream.close();
            }
            connection.connect();

            if(connection.getResponseCode()==HttpURLConnection.HTTP_OK){
                BufferedReader bufferedReader= new BufferedReader(
                        new BufferedReader(
                                new InputStreamReader(
                                        connection.getInputStream()
                                )
                        )

                );
                String jsonResult="";
                String temp;
                while ((temp= bufferedReader.readLine())!=null){
                    jsonResult+=temp;
                }

                result.setJson(jsonResult);
                result.setSuccessful(true);
            }else{
                result.setMessage(context.getString(R.string.msj_malformed));
            }
        } catch (MalformedURLException e) {
            result.setMessage(context.getString(R.string.msj_malformed));
            e.printStackTrace();
        } catch (IOException e) {
            result.setMessage(context.getString(R.string.msj_malformed));
            e.printStackTrace();
        }
        return result;
    }
}
