package com.example.mariaquinonez.mcparametros.objects.ws;

/**
 * Created by maria.quinonez on 30/11/2017.
 */

public class ServerResponse {
    private String message;
    private boolean successful;
    private String json;

    public ServerResponse() {
        successful=true;
    }


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

    public String getJson() {
        return json;
    }

    public void setJson(String json) {
        this.json = json;
    }
}
