package com.example.mariaquinonez.mcparametros.dataBase;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.mariaquinonez.mcparametros.objects.Parametros;

/**
 * Created by maria.quinonez on 05/12/2017.
 */

public class DatabaseManager extends SQLiteOpenHelper {
    private static String DATABASE_NAME="CSCTrainingDB";
    private static int DATABASE_VERSION=1;

    public DatabaseManager(Context context){
        super(context,DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        //Parametros.createTable(sqLiteDatabase);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {

    }
    @Override
    public void onDowngrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion){
        //Parametros.deleteTable(sqLiteDatabase);

    }
}
