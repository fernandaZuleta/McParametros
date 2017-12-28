package com.example.mariaquinonez.mcparametros.objects;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

/**
 * Created by maria.quinonez on 21/12/2017.
 */

public class ActualizaResp implements Serializable {
    @JsonProperty(value = "PARAMETROS")
    private String parametros;

    public String getParametros() {
        return parametros;
    }

    public void setParametros(String parametros) {
        this.parametros = parametros;
    }
}
