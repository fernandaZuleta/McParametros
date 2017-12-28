package com.example.mariaquinonez.mcparametros.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.mariaquinonez.mcparametros.R;

public class OptionsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_options);
    }
    public void goToCountries(View view) {
        startActivity(new Intent(this, ParametrosActivity.class));
    }
}
