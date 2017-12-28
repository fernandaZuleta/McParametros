package com.example.mariaquinonez.mcparametros.objects;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by maria.quinonez on 21/12/2017.
 */

public class ParametrosParcelable implements Parcelable {


    public Parametros parametros;

    public ParametrosParcelable() {
    }

    protected ParametrosParcelable(Parcel in) {
        parametros = (Parametros) in.readValue(Parametros.class.getClassLoader());
    }

    public Parametros getParametros() {
        return parametros;
    }

    public void setParametros(Parametros parametros) {
        this.parametros = parametros;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(parametros);
    }

    @SuppressWarnings("unused")
    public static final Parcelable.Creator<ParametrosParcelable> CREATOR = new Parcelable.Creator<ParametrosParcelable>() {
        @Override
        public ParametrosParcelable createFromParcel(Parcel in) {
            return new ParametrosParcelable(in);
        }

        @Override
        public ParametrosParcelable[] newArray(int size) {
            return new ParametrosParcelable[size];
        }
    };
}