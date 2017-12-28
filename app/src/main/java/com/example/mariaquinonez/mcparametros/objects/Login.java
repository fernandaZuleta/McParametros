package com.example.mariaquinonez.mcparametros.objects;

import com.example.mariaquinonez.mcparametros.dataBase.Model;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

/**
 * Created by maria.quinonez on 19/12/2017.
 */

public class Login implements Serializable{
    @JsonProperty(value = "LOGIN")
    private String login;

    public Login() {
    }

    public Login(String LOGIN) {

        this.login = LOGIN;

    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }
}
