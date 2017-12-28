package com.example.mariaquinonez.mcparametros.dataBase;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import java.net.PortUnreachableException;
import java.util.Collection;

/**
 * Created by maria.quinonez on 05/12/2017.
 */

public class Model {
    public static final String SQL_CREATE_TABLE="CREATE TABLE ";
    public static final String SQL_DETETE_TABLE="DROP TABLE ";
    public static final String SQL_DELETE_IF_TABLE="DROP TABLE IF EXIST ";

    public static final String SQL_AUTOINCREMENT_ID=" INTEGER PRIMARY KEY AUTOINCREMENT, ";
    public static final String SQL_TYPE_INT=" INTEGER";
    public static final String SQL_TYPE_TEXT=" TEXT";
    public static final String SQL_TYPE_NUMBER=" NUMBER";

    public static final String SQL_SEP= ", ";
    public static final String FIELD_ID="id";

    public static void createTable(SQLiteDatabase sqLiteDatabase){}
    public static void deleteTable(SQLiteDatabase sqLiteDatabase){}
    public static Collection findAll(Context context){return  null;}
    public static Collection find(Context context, String whereClause, String[] whereArgs){
        return null;
    }
    public boolean save(Context context){
        return false;
    }
    public boolean delete(Context context){
        return false;
    }
}
