package com.example.mariaquinonez.mcparametros.objects.ws.response;

import com.example.mariaquinonez.mcparametros.objects.Parametros;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/**
 * Created by maria.quinonez on 19/12/2017.
 */

public class GetParametrosResponse extends BaseResponse {
    @JsonProperty(value = "resp")
    private List<Parametros> parametrosList;

    public List<Parametros> getParametrosList() {
        return parametrosList;
    }

    public void setParametrosList(List<Parametros> parametrosList) {
        this.parametrosList = parametrosList;
    }
}
