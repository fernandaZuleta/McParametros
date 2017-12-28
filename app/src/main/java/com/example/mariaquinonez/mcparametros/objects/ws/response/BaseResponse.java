package com.example.mariaquinonez.mcparametros.objects.ws.response;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by maria.quinonez on 19/12/2017.
 */

public class BaseResponse {
    @JsonProperty(value = "mensaje")
    private String message;
    private boolean successful;
    @JsonProperty
    private String codigo;


    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public boolean isSuccessful() {
        return successful;
    }

    public void setSuccessful(boolean successful) {
        this.successful = successful;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
        this.successful=(codigo.equalsIgnoreCase("0000"));
    }
}
