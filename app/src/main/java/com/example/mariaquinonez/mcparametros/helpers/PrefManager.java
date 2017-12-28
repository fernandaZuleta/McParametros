package com.example.mariaquinonez.mcparametros.helpers;

import android.content.Context;
import android.content.SharedPreferences;

import com.example.mariaquinonez.mcparametros.objects.Parametros;

import java.util.List;

/**
 * Created by maria.quinonez on 05/12/2017.
 */

public class PrefManager {
    private static final String PREF_NAME="PreferencesCSCTraining";

    private static final String SESSION_ID="sessionId";

    public static void setSessionId(Context context, String sessionId){
        SharedPreferences.Editor editor= getEditor(context);
        editor.putString(SESSION_ID, sessionId);
        editor.commit();

    }


    public static  String getSessionId(Context context){
        return getPreferences(context).getString(SESSION_ID, "No hemos guardado sesión");

    }
    public static void deleteSessionId(Context context){
        //SharedPreferences.Editor editor= getEditor(context);
        //editor.remove(SESSION_ID);
        //editor.commit();
        deleteKey(context,SESSION_ID);
    }
    private void explorePreferences(Context context){
        SharedPreferences sharedPreferences=
                getPreferences(context);
        SharedPreferences.Editor editor= sharedPreferences.edit();
        editor.putBoolean("KeyBool", true);
        editor.putFloat("KeyFloor", 45f);
        editor.putInt("KeyInt", 45);
        editor.putLong("KeyLong",45l);
        editor.putString("KeyString", "String");
        editor.commit();

        sharedPreferences.getBoolean("KeyBool",false);
        sharedPreferences.getLong("KeyLong",0l);
    }
    private static void deleteKey(Context context, String key){
        SharedPreferences.Editor editor= getEditor(context);
        editor.remove(key);
        editor.commit();
    }
    private static SharedPreferences.Editor getEditor(Context context){
        return getPreferences(context).edit();
    }
    private static SharedPreferences getPreferences(Context context){
        return context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
    }
}
