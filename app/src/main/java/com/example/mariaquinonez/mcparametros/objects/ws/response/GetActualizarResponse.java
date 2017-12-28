package com.example.mariaquinonez.mcparametros.objects.ws.response;

import com.example.mariaquinonez.mcparametros.objects.ActualizaResp;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by maria.quinonez on 21/12/2017.
 */

public class GetActualizarResponse extends BaseResponse {
    @JsonProperty(value = "resp")
    private ActualizaResp parametros;

    public ActualizaResp getParametros() {
        return parametros;
    }

    public void setParametros(ActualizaResp parametros) {
        this.parametros = parametros;
    }
}
