package com.example.mariaquinonez.mcparametros.helpers;

import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.text.TextUtils;

/**
 * Created by maria.quinonez on 30/11/2017.
 */

public class CustomDialogs {
    public static void showOk(String tittle, String message, String btn, Context context){
        AlertDialog.Builder builder= new AlertDialog.Builder(context);
        if(!TextUtils.isEmpty(tittle)){
        builder.setTitle(tittle);

    }
    if(!TextUtils.isEmpty(message)){
        builder.setMessage(message);

    }
    builder.setNeutralButton(btn, new DialogInterface.OnClickListener() {
        @Override
        public void onClick(DialogInterface dialogInterface, int i) {

        }
    });
        builder.create().show();
    }

}
