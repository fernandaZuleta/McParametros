package com.example.mariaquinonez.mcparametros.objects;

import com.example.mariaquinonez.mcparametros.dataBase.Model;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

/**
 * Created by maria.quinonez on 19/12/2017.
 */

public class Parametros  implements Serializable{
    public static final String TABLE_NAME="ParametrosActivity";

    @JsonProperty(value = "COD_PARAMETRO")
    private String codParametro;

    @JsonProperty(value = "NO_CIA")
    private String noCia;

    @JsonProperty(value = "DATO")
    private String dato;

    @JsonProperty(value = "NOMBRE")
    private String nombre;

    public Parametros() {
    }

    public Parametros(String codParametro, String noCia, String dato, String nombre) {
        this.codParametro = codParametro;
        this.noCia = noCia;
        this.dato = dato;
        this.nombre = nombre;
    }

    public String getCodParametro() {
        return codParametro;
    }

    public void setCodParametro(String codParametro) {
        this.codParametro = codParametro;
    }

    public String getNoCia() {
        return noCia;
    }

    public void setNoCia(String noCia) {
        this.noCia = noCia;
    }

    public String getDato() {
        return dato;
    }

    public void setDato(String dato) {
        this.dato = dato;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
