package com.example.mariaquinonez.mcparametros.objects.ws.response;

import com.example.mariaquinonez.mcparametros.objects.Login;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by maria.quinonez on 19/12/2017.
 */

public class GetLoginResponse extends BaseResponse {
    @JsonProperty(value = "resp")
    private Login login;

    public Login getLogin() {
        return login;
    }

    public void setLogin(Login login) {
        this.login = login;
    }
}
